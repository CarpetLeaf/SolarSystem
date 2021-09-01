package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Main extends JComponent {

    private double[][] angle;
    private boolean showTr = true;
    private boolean showName = true;
    private double speedCoef = 1;
    private boolean showTrSat = true;
    private boolean showNameSat = true;


    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x-r, y-r, 2 * r, 2 * r);
    }

    public ArrayList<Planet> getPlanets(){
        ArrayList<Planet> planet_array = new ArrayList<>();
        ArrayList<Satellite> satellites = new ArrayList<>();
        Planet mercury = new Planet("Mercury", 2.44, 57.91, 88);
        planet_array.add(mercury);
        Planet venus = new Planet("Venus", 6.051, 108, 224.7);
        planet_array.add(venus);
        Planet earth = new Planet("Earth", 6.371, 149.6, 365.25);
            Satellite satellite = new Satellite("Moon", 1.737, 0.384, 27.32);
            satellites.add(satellite);
        earth.setSatellites(satellites);
        planet_array.add(earth);
        satellites.clear();
        Planet mars = new Planet("Mars", 3.396, 228, 687);
            satellite = new Satellite("Deimos", 0.023, 0.023, 27.32);
            satellites.add(satellite);;
            satellite = new Satellite("Phobos", 0.011, 0.009, 6.83);
            satellites.add(satellite);
        mars.setSatellites(satellites);
        planet_array.add(mars);
        satellites.clear();
        Planet jupiter = new Planet("Jupiter", 71, 778.3, 11.86 * earth.getPeriod());
            satellite = new Satellite("Ganymed", 2.634, 1.07, 7.15);
            satellites.add(satellite);
            satellite = new Satellite("Io", 1.821, 0.421, 1.77);
            satellites.add(satellite);
            satellite = new Satellite("Europe", 1.561, 0.666, 3.5);
            satellites.add(satellite);
            satellite = new Satellite("Callisto", 2.41, 1.882, 16.69);
            satellites.add(satellite);
        jupiter.setSatellites(satellites);
        planet_array.add(jupiter);
        satellites.clear();
        Planet saturn = new Planet("Saturn", 60, 1427, 29.45 * earth.getPeriod());
            satellite = new Satellite("Titan", 2.576, 1.221, 16);
            satellites.add(satellite);
            satellite = new Satellite("Enceladus", 0.257, 0.177, 1.375);
            satellites.add(satellite);
            satellite = new Satellite("Mimas", 0.208, 0.185, 0.942);
            satellites.add(satellite);
            satellite = new Satellite("Iapetus", 0.748, 3.56, 79.33);
            satellites.add(satellite);
            satellite = new Satellite("Pandora", 0.052, 0.141, 0.625);
            satellites.add(satellite);
        saturn.setSatellites(satellites);
        planet_array.add(saturn);
        satellites.clear();
        Planet uranus = new Planet("Uranus", 25.9, 2870, 84 * earth.getPeriod());
            satellite = new Satellite("Oberon", 0.764, 0.584, 13.5);
            satellites.add(satellite);
            satellite = new Satellite("Titania", 0.788, 0.436, 8.71);
            satellites.add(satellite);
            satellite = new Satellite("Umbriel", 0.586, 0.266, 4.144);
            satellites.add(satellite);
            satellite = new Satellite("Ariel", 0.579, 0.191, 2.5);
            satellites.add(satellite);
            satellite = new Satellite("Miranda", 0.236, 0.129, 1.41);
            satellites.add(satellite);
        uranus.setSatellites(satellites);
        planet_array.add(uranus);
        satellites.clear();
        Planet neptune = new Planet("Neptune", 24.75, 4497, 164.8 * earth.getPeriod());
            satellite = new Satellite("Triton", 1.354, 0.33, 5.88);
            satellites.add(satellite);
            satellite = new Satellite("Nereid", 0.17, 5.5, 360.14);
            satellites.add(satellite);
            satellite = new Satellite("Proteus", 0.22, 0.117, 1.12);
            satellites.add(satellite);
            satellite = new Satellite("Larissa", 0.105, 0.074, 0.55);
            satellites.add(satellite);
            satellite = new Satellite("Galatea", 0.092, 0.62, 0.43);
            satellites.add(satellite);
        neptune.setSatellites(satellites);
        planet_array.add(neptune);
        return  planet_array;
    }

    public Main() {
        angle = new double[8][6];
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0; i<8; i++) {
                    angle[i][0] += 0.05 * speedCoef / getPlanets().get(i).getPeriod();
                    int j=1;
                    for (Satellite st : getPlanets().get(i).getSatellites()){
                        angle[i][j] += 0.05*speedCoef/st.getPeriod();
                        j++;
                    }
                }
                repaint();
            }
        });
        timer.start();
    }

    public static void main(String... args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                Main test = new Main();
                JFrame frame = new JFrame();
                JMenuBar jMenuBar = new JMenuBar();
                JMenu speed = new JMenu("Speed");
                JMenuItem increase = new JMenuItem(new AbstractAction("Increase") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.speedCoef *= 2;
                    }
                });
                JMenuItem reduce = new JMenuItem(new AbstractAction("Reduce") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.speedCoef /= 2;
                    }
                });
                speed.add(increase);
                speed.add(reduce);
                JMenu trajectory  = new JMenu("Trajectory");
                JMenuItem showTrajectory = new JMenuItem(new AbstractAction("Show") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.showTr = true;
                    }
                });
                JMenuItem hideTrajectory = new JMenuItem(new AbstractAction("Hide") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.showTr = false;
                    }
                });
                trajectory.add(showTrajectory);
                trajectory.add(hideTrajectory);
                JMenu name = new JMenu("Names");
                JMenuItem showName = new JMenuItem(new AbstractAction("Show") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.showName = true;
                    }
                });
                JMenuItem hideName = new JMenuItem(new AbstractAction("Hide") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.showName = false;
                    }
                });
                name.add(showName);
                name.add(hideName);
                JMenu trajectorySat  = new JMenu("Satellite trajectory");
                JMenuItem showTrajectorySat = new JMenuItem(new AbstractAction("Show") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.showTrSat = true;
                    }
                });
                JMenuItem hideTrajectorySat = new JMenuItem(new AbstractAction("Hide") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.showTrSat = false;
                    }
                });
                trajectorySat.add(showTrajectorySat);
                trajectorySat.add(hideTrajectorySat);
                JMenu nameSat = new JMenu("Satellites names");
                JMenuItem showNameSat = new JMenuItem(new AbstractAction("Show") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.showNameSat = true;
                    }
                });
                JMenuItem hideNameSat = new JMenuItem(new AbstractAction("Hide") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        test.showNameSat = false;
                    }
                });
                nameSat.add(showNameSat);
                nameSat.add(hideNameSat);
                jMenuBar.add(speed);
                jMenuBar.add(trajectory);
                jMenuBar.add(name);
                jMenuBar.add(nameSat);
                jMenuBar.add(trajectorySat);
                JScrollPane scrollPane = new JScrollPane(test);
                frame.setJMenuBar(jMenuBar);
                frame.add(scrollPane);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10500, 10500);
    }



    @Override
    protected void paintComponent(Graphics g) {
        ArrayList<Color> colorSet = new ArrayList<>();
        colorSet.add(new Color(233,153,67));
        colorSet.add(new Color(238,225,174));
        colorSet.add(new Color(105,201,231));
        colorSet.add(new Color(234,75,67));
        colorSet.add(new Color(255,1,246));
        colorSet.add(new Color(184,194,21));
        colorSet.add(new Color(129,129,129));
        colorSet.add(new Color(1,6,253));
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.yellow);
        g2.fill(circle(4870,4870, 600));
        g2.setColor(Color.black);
        g2.drawString("Sun", 4870, 4870);
        int i=0;
        for (Planet planet : getPlanets()){
            g2.setColor(colorSet.get(i));
            g2.fill(circle(4870+(695.99+planet.getDistance())*Math.cos(angle[i][0]), 4870+(695.99+planet.getDistance())*Math.sin(angle[i][0]), planet.getRadius()));
            if (planet.getSatellites().size() > 0){
                int j=1;
                for (Satellite st : planet.getSatellites()){
                    g2.setColor(colorSet.get(j-1));
                    g2.fill(circle(4870+(695.99+planet.getDistance())*Math.cos(angle[i][0])+(st.getDistance()*10+planet.getRadius())*Math.cos(angle[i][j]), 4870+(695.99+planet.getDistance())*Math.sin(angle[i][0])+(st.getDistance()*10+planet.getRadius())*Math.sin(angle[i][j]), st.getRadius()));
                    g2.setColor(Color.black);
                    if (showTrSat == true)
                        g2.draw(circle(4870+(695.99+planet.getDistance())*Math.cos(angle[i][0]), 4870+(695.99+planet.getDistance())*Math.sin(angle[i][0]), planet.getRadius() + st.getDistance()*10));
                    if (showNameSat == true)
                        g2.drawString(st.getName(), (float)(4870+(695.99+planet.getDistance())*Math.cos(angle[i][0])+(st.getDistance()*10+planet.getRadius())*Math.cos(angle[i][j])), (float)(4870+(695.99+planet.getDistance())*Math.sin(angle[i][0])+(st.getDistance()*10+planet.getRadius())*Math.sin(angle[i][j])));
                    j++;
                }
            }
            g2.setColor(Color.black);
            if (showName == true)
                g2.drawString(planet.getName(), (float)(4872+(695.99+planet.getDistance())*Math.cos(angle[i][0])), (float)(4872+(695.99+planet.getDistance())*Math.sin(angle[i][0])));
            if (showTr == true)
                g2.draw(circle(4870, 4870, planet.getDistance() + 695.99));
            i++;
        }
    }
}