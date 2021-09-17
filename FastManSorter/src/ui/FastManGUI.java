package ui;

import java.awt.CardLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FastManGUI {

    /** JFrame for the GUI */
    private static JFrame       gui;
    /** FastManGUI title */
    private static final String TITLE = "Fast Manual Sorter";
    /** CardLayout for GUI */
    // private final CardLayout cardLayout;
    /** Panel that will contain all of the application views */
    private static JPanel       mainPanel;

    private final CardLayout    layout;

    private static ImageIcon    displayImage;

    private static JLabel       label;

    /**
     * Constructs the FastManGUI
     */
    public FastManGUI ( final String currentDirectory ) {
        gui = new JFrame();
        gui.setSize( 800, 800 );
        gui.setLocation( 50, 50 );
        gui.setTitle( TITLE );

        mainPanel = new JPanel();
        layout = new CardLayout();
        mainPanel.setLayout( layout );

        final JLabel dirDisp = new JLabel();
        dirDisp.setText( "Current Directory: " + currentDirectory );
        mainPanel.add( dirDisp );
        gui.add( mainPanel );

        gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        gui.setVisible( true );
    }

    /**
     * Starts the program.
     *
     * @param args
     *            command line arguments
     */
    public static void main ( final String[] args ) {

        final String currentDir = System.getProperty( "user.dir" );
        System.out.println( currentDir );

        new FastManGUI( currentDir );

        final File folder = new File( currentDir );
        final File[] listOfFiles = folder.listFiles();

        for ( final File file : listOfFiles ) {
            // if ( file.isFile() ) {
            System.out.println( file.getName() );
            // }
        }

        // imageDisplayer( stringDir );

    }

    public static void imageDisplayer ( final String directoryURL ) {
        final String shouldURL = "C:\\Users\\vulpi\\NCSU\\CSC326\\FastManSorter\\src\\ui\\koan dynasty.jpg";
        System.out.println( shouldURL );
        displayImage = new ImageIcon( shouldURL );
        label = new JLabel( displayImage );
        gui.add( label );
        gui.pack();
    }
}
