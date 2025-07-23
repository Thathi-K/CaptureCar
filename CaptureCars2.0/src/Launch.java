import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

public class Launch implements ActionListener{

    JFrame frame=new JFrame("Vehicles");

    List <Car> carList=new ArrayList<>();

    JPanel mainPanel=new JPanel();

    JButton takeInfo=new JButton("Input Vehicle Information");
    JButton displayInfo=new JButton("View Vehicle Report");
    JButton exit=new JButton("Exit");
    JButton back=new JButton("Back");
    JButton save=new JButton("Save");

    JTextField[] input=new JTextField[6];


    Dimension size=new Dimension(200,40);

    public Launch(){

        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(frame.CENTER_ALIGNMENT);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        takeInfo.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        takeInfo.setPreferredSize(new Dimension(200,40));
        takeInfo.setMaximumSize(new Dimension(200,40));
        takeInfo.setFocusable(false);
        takeInfo.addActionListener(this);



        displayInfo.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        displayInfo.setPreferredSize(size);
        displayInfo.setMaximumSize(size);
        displayInfo.setFocusable(false);
        displayInfo.addActionListener(this);


        exit.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
        exit.setPreferredSize(size);
        exit.setMaximumSize(size);
        exit.setFocusable(false);
        exit.addActionListener(this);

        save.addActionListener(this);

        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(takeInfo);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(displayInfo);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(exit);
        mainPanel.add(Box.createVerticalGlue());

        frame.add(mainPanel);

        frame.pack();
        frame.setSize(420,400);

    }

    @Override
    public void actionPerformed(ActionEvent e){

        //What happens when the input Vehicle information is pressed
        if(e.getSource()==takeInfo){

            mainPanel.removeAll();

            JPanel newPanel=new JPanel(new GridLayout(7,2,10,10));
            String [] labels={"Make:","Model:","Vin:","Plate Number","Year","Milliage:"};


            for(int i=0;i<input.length;i++){

                JLabel label=new JLabel(labels[i]);
                input[i]=new JTextField(15);
                if(i==4){

                    JLabel choices=new JLabel("Enter plate number e.g. AAA555GP/AA66BBGP");
                    JLabel nothing=new JLabel(" ");
                    choices.setPreferredSize(size);
                    choices.setAlignmentX(Component.CENTER_ALIGNMENT);

                    newPanel.add(nothing);
                    newPanel.add(choices);

                }
                input[i].setAlignmentX(mainPanel.CENTER_ALIGNMENT);
                label.setPreferredSize(size);
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
                newPanel.add(label);
                newPanel.add(input[i]);

            }



            back.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
            back.setPreferredSize(size);
            back.setMaximumSize(size);
            back.addActionListener(this);
            save.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
            save.setPreferredSize(size);
            save.setMaximumSize(size);






            mainPanel.add(Box.createVerticalGlue());
            mainPanel.add(newPanel);
            mainPanel.add(Box.createVerticalStrut(20));
            mainPanel.add(save);
            mainPanel.add(Box.createVerticalStrut(20));
            mainPanel.add(back);
            mainPanel.add(Box.createVerticalGlue());






            frame.revalidate();
            frame.repaint();





        }


        //what happens when the save button is pressed
        if(e.getSource()==save){

            for(int i=0;i<input.length;i++){

                if(input[i].getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Please fill in all fields before saving");
                    return;
                }

            }

            if(input[2].getText().length()!=17){

                JOptionPane.showMessageDialog(frame,"Please Make sure Vin is 17 characters");

            }else{

                try{

                    Car car=new Car();
                    car.setMake(input[0].getText());
                    car.setModel(input[1].getText());
                    car.setVin(input[2].getText());
                    car.setPlateNumber(input[3].getText());
                    car.setYear(Integer.parseInt(input[4].getText()));
                    car.setMillage(Integer.parseInt(input[5].getText().trim().replace(" ","")));

                    if(carList!=null &&!carList.contains(car)){
                        carList.add(car);
                        JOptionPane.showMessageDialog(frame,"Car saved successfully!");
                    }else{JOptionPane.showMessageDialog(frame,"Car already exists!");}
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame,"Please enter Valid numbers for Year and miliage");
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(frame,"Unexpected error: "+ex.getMessage());
                }
            }
        }


        //What happens when the display button is pressed
        if(e.getSource()==displayInfo){

            mainPanel.removeAll();

            //creating a line at the top
			/*JSeparator topLine=new JSeparator(SwingConstants.HORIZONTAL);
			topLine.setMaximumSize(new Dimension(Integer.MAX_VALUE,1));*/



            JPanel reportPanel=new JPanel();
            reportPanel.setLayout(new BoxLayout(reportPanel,BoxLayout.Y_AXIS));
            reportPanel.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
            reportPanel.setMaximumSize(null);

            if(carList.isEmpty()){
                JLabel noCars=new JLabel("There are no cars captured");
                noCars.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
                reportPanel.add(noCars);

            }else{



                for(Car car:carList){
                    JPanel carPanel=new JPanel();
                    carPanel.setLayout(new BoxLayout(carPanel,BoxLayout.Y_AXIS));
                    carPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

                    //Labels for all the inputed data
                    JLabel makeLabel=new JLabel("Make: "+car.getMake());
                    JLabel modelLabel=new JLabel("Model: "+car.getModel());
                    JLabel vinLabel=new JLabel("Vin: "+car.getVin());
                    JLabel plateLabel=new JLabel("Number Plate: "+car.getPlateNumber());
                    JLabel yearLabel=new JLabel("Year: "+car.getYear());
                    JLabel millageLabel=new JLabel("Millage: "+car.getMillage());

                    //Centering all the labels
                    makeLabel.setAlignmentX(reportPanel.CENTER_ALIGNMENT);
                    modelLabel.setAlignmentX(reportPanel.CENTER_ALIGNMENT);
                    vinLabel.setAlignmentX(reportPanel.CENTER_ALIGNMENT);
                    plateLabel.setAlignmentX(reportPanel.CENTER_ALIGNMENT);
                    yearLabel.setAlignmentX(reportPanel.CENTER_ALIGNMENT);
                    millageLabel.setAlignmentX(reportPanel.CENTER_ALIGNMENT);

                    carPanel.add(makeLabel);
                    carPanel.add(modelLabel);
                    carPanel.add(vinLabel);
                    carPanel.add(plateLabel);
                    carPanel.add(yearLabel);
                    carPanel.add(millageLabel);

                    reportPanel.add(carPanel);

                }




            }


            back.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
            back.setPreferredSize(size);
            back.addActionListener(this);

            JLabel top=new JLabel("VEHICLE REPORT");
            top.setAlignmentX(mainPanel.CENTER_ALIGNMENT);
            top.setPreferredSize(size);
            mainPanel.add(top);

            mainPanel.add(Box.createVerticalGlue());
            //Scrollable frame
            JScrollPane scrollPane=new JScrollPane(reportPanel);
            scrollPane.setBorder(null);
            scrollPane.setPreferredSize(null);
            mainPanel.add(scrollPane);
            mainPanel.add(back);
            mainPanel.add(Box.createVerticalGlue());

            frame.revalidate();
            frame.repaint();

        }


        //Going back to the mainMenu
        if(e.getSource()==back){
            mainPanel.removeAll();

            mainPanel.add(Box.createVerticalGlue());
            mainPanel.add(takeInfo);
            mainPanel.add(Box.createVerticalStrut(20));
            mainPanel.add(displayInfo);
            mainPanel.add(Box.createVerticalStrut(20));
            mainPanel.add(exit);
            mainPanel.add(Box.createVerticalGlue());




            frame.revalidate();
            frame.repaint();

        }



        if(e.getSource()==exit){

            System.exit(0);

        }

    }


}