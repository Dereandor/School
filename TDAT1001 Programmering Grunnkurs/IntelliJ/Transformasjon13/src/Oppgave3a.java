import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.jogamp.opengl.util.gl2.GLUT;

import com.jogamp.opengl.util.FPSAnimator;

public class Oppgave3a  extends GLCanvas implements GLEventListener {
    
    private static String TITLE = "Oppgave3a";
    private static final int CANVAS_WIDTH = 1280;  // width of the drawable
    private static final int CANVAS_HEIGHT = 960; // height of the drawable
    
    // Setup OpenGL Graphics Renderer
    private GLU glu;  // for the GL Utility
    
    /** Constructor to setup the GUI for this Component */
    public Oppgave3a() {
        this.addGLEventListener(this);
    }

// ------ Implement methods declared in GLEventListener (init,reshape,display,dispose)
    
    /**
     * Called immediately after the OpenGL context is initialized. Can be used
     * to perform one-time initialization. Run only once.
     */
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();      // get the OpenGL graphics context
        glu = new GLU();                         // get GL Utilities
        gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f); // set background (clear) color
        gl.glEnable(GL2.GL_DEPTH_TEST); // enables depth testing
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // best perspective correction
        gl.glShadeModel(GL2.GL_SMOOTH); // blends colors nicely
    }
    
    /**
     * Handler for window re-size event. Also called when the drawable is
     * first set to visible
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
        
        if (height == 0) height = 1;   // prevent divide by zero
        float aspect = (float)width / height;
        
        //Set the view port (display area) to cover the entire window
        //gl.glViewport(0, 0, width, height);
        
        // Setup perspective projection, with aspect ratio matches viewport
        gl.glMatrixMode(GL2.GL_PROJECTION);  // choose projection matrix
        gl.glLoadIdentity();             // reset projection matrix
        glu.gluPerspective(45.0, aspect, 0.1, 200.0); // fovy, aspect, zNear, zFar
        
        // Enable the model-view transform
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity(); // reset
    }
    
    /**
     * Called by OpenGL for drawing
     */
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
        GLUT glut = new GLUT();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
        gl.glLoadIdentity();  // reset the model-view matrix
        
        // ----- Render figures -----
        gl.glRotatef(45, 0.1f,0.0f,0.5f);
        gl.glTranslatef(0.0f, 0.0f, -5.0f);
        gl.glColor3f(0.0f, 0.0f, 0.5f);
        glut.glutWireCube(1.0f);
    }
    
    /**
     * Called before the OpenGL context is destroyed. Release resource such as buffers.
     */
    public void dispose(GLAutoDrawable drawable) { }
    
    /** The entry main() method to setup the top-level JFrame with our OpenGL canvas inside */
    public static void main(String[] args) {
        GLCanvas canvas = new Oppgave3a();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        
        final JFrame frame = new JFrame(); // Swing's JFrame or AWT's Frame
        frame.getContentPane().add(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//stop program
        frame.setTitle(TITLE);
        frame.pack();
        frame.setVisible(true);
    }
}
