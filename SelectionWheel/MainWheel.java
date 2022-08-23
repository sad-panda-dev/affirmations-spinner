package SelectionWheel;
import javax.swing.*;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;

public class MainWheel {

    public static void main(String[] args) throws Exception {

        int width = 1000;
        int height = 1000;

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        HashMap<String, String> map = new HashMap<>();
        map.put("Worthiness", "I am worthy of the ultimate happiness");
        map.put("Self-Love", "I openly embrace a feeling of self-love");
        map.put("Don't Take It Personally", "If someone starts to speak unkindly to me, I'll remember that they've got something going on that has nothing to do with me.");
        map.put("Engagement", "Today, I make the conscious choice to engage with the world in an active way.");
        map.put("Inspiration", "There is a voice of inspiration within me.");
        map.put("Peacefulness", "I have a peaceful, tranquil, and untroubled heart. This is where I choose to spend my time.");
        map.put("Story Of My Life", "As I tell myself the story of what's happening in my life, I choose to make it the kind of story where even the tough parts have a sort of inner beauty.");
        map.put("Trust", "I trust that everything will be okay in the end.");
        map.put("Ultimate Potential", "I choose to live a life of my fullest potential.");
        map.put("Ups And Downs", "I see life as an incredible ride, and I'm lucky to be on it.");
        map.put("Clarity", "Stopping to listen to my inner self, I can easily separate my intuition from my mental chatter.");
        map.put("Confidence", "In this moment, I take a step back and look at myself with the pride of a good mother.");
        map.put("Connection", "I'm connected to the multitudes, and I can access their support at any time.");
        map.put("Courage", "No one is fearless. No one. But even though I'm not fearless, I am courageous. When fear shows up, I don't run away from it.");
        map.put("Divine Timing", "Everything is timing and timing is everything. Gladly, I release my concern over timing and let things happen when--and as--they will.");
        map.put("Power", "I am strong, I am grounded, I am powerful.");
        map.put("Options", "As I open to the abundant possibilities of my life's path, I'm reminded that I always have unlimited options. Life is a buffet, and I allow myself to choose whatever makes me happiest.");
        map.put("Wonder", "It's a wonderful thing to be in a state of wonder.");
        map.put("Joy", "To enjoy something, I simply need to add joy to it. Joy is like butter--I can put it on anything and it'll make it way better.");
        map.put("Letting Go", "I don't dwell on bad things that happened. I let things go because I have enough heavy things to carry around...and also, grudges aren't a great look.");

        SelectionWheel wheel = new SelectionWheel(map.keySet());
        wheel.hasBorders(true);
        wheel.setBounds(10, 10, 700, 700);

        JLabel lbl1 = new JLabel("Selection: ");
        JLabel lbl2 = new JLabel("Angle: ");
        JLabel lbl3 = new JLabel("Speed: ");
        JLabel lblsel = new JLabel("(selection)");
        JLabel lblang = new JLabel("(angle)");
        JLabel lblsp = new JLabel("(speed)");
        lbl1.setBounds(720, 10, 100, 20);
        lblsel.setBounds(830, 10, 150, 20);
        lbl2.setBounds(720, 10, 100, 20);
        lblang.setBounds(830, 10, 150, 20);
        lbl3.setBounds(720, 10, 100, 20);
        lblsp.setBounds(830, 10, 150, 20);
        frame.add(wheel);
        frame.add(lbl1);
        frame.add(lblsel);
        frame.add(lbl2);
        frame.add(lblang);
        frame.add(lbl3);
        frame.add(lblsp);
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setVisible(true);

        lblsel.setText(wheel.getSelectedString());
        lblang.setText(Double.toString(wheel.getRotationAngle()));
        lblsp.setText(Double.toString(wheel.getSpinSpeed()));

        while(true) {
            //wait for action
            while(true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(wheel.isSpinning())
                    break;
            }
            //wheel is spinning
            while(wheel.isSpinning()) {
                lblsel.setText(wheel.getSelectedString());
                lblang.setText(Double.toString(wheel.getRotationAngle()));
                lblsp.setText(Double.toString(wheel.getSpinSpeed()));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lblsp.setText(Double.toString(wheel.getSpinSpeed()));
            //show selection
            JOptionPane.showMessageDialog(frame, "Selection: " + wheel.getSelectedString());
        }
    }
}
