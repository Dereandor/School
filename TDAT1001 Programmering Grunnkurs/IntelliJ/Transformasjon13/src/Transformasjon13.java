//Oppgave 1

import java.awt.*;
import javax.swing.*;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;

class Transformasjon13 extends GLCanvas implements GLEventListener {
    private static String TITLE = "Transformasjon 13";
    private static final int CANVAS_WIDTH = 1280;  // width of the drawable
    private static final int CANVAS_HEIGHT = 960; // height of the drawable
    private double[][] pointArray = {{0.0,2.0,0.0},{1.5,1.5,0.0},{2.0,0.0,0.0},{1.5,-1.5,0.0},{0.0,-2.0,0.0},{-1.5,-1.5,0.0},{-2.0,0.0,0.0},{-1.5,1.5,0.0}}; //array of 8 different points xyz

    // Setup OpenGL Graphics Renderer
    private GLU glu;  // for the GL Utility

    /** Constructor to setup the GUI for this Component */
    public Transformasjon13() {
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
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
        gl.glLoadIdentity();  // reset the model-view matrix

        // ----- Render figures -----
        gl.glTranslatef(0.0f, 0.0f, -30.0f);
        gl.glColor3f(0.0f, 0.0f, 0.5f);
        gl.glBegin(GL2.GL_POINT);
    
        for (int i = 0; i < 8; i++) {
            gl.glVertex3dv(pointArray[i],0);
        }
        gl.glEnd();
        
        gl.glTranslatef(4.0f, 0.0f, 0.0f);
        
        gl.glBegin(GL2.GL_LINES);
        for (int i = 0; i < 8; i++) {
            gl.glVertex3dv(pointArray[i],0);
        }
        gl.glEnd();
    
        gl.glTranslatef(0.0f, 4.0f, 0.0f);
    
        gl.glBegin(GL2.GL_LINE_STRIP);
        for (int i = 0; i < 8; i++) {
            gl.glVertex3dv(pointArray[i],0);
        }
        gl.glEnd();
    
        gl.glTranslatef(-4.0f, 0.0f, 0.0f);
    
        gl.glBegin(GL2.GL_LINE_LOOP);
        for (int i = 0; i < 8; i++) {
            gl.glVertex3dv(pointArray[i],0);
        }
        gl.glEnd();
    
        gl.glTranslatef(-4.0f, 0.0f, 0.0f);
    
        gl.glBegin(GL2.GL_TRIANGLES);
        for (int i = 0; i < 8; i++) {
            gl.glVertex3dv(pointArray[i],0);
        }
        gl.glEnd();
    
        gl.glTranslatef(0.0f, -4.0f, 0.0f);
    
        gl.glBegin(GL2.GL_TRIANGLE_STRIP);
        for (int i = 0; i < 8; i++) {
            gl.glVertex3dv(pointArray[i],0);
        }
        gl.glEnd();
    
        gl.glTranslatef(0.0f, -4.0f, 0.0f);
    
        gl.glBegin(GL2.GL_TRIANGLE_FAN);
        for (int i = 0; i < 8; i++) {
            gl.glVertex3dv(pointArray[i],0);
        }
        gl.glEnd();
    
        gl.glTranslatef(4.0f, 0.0f, 0.0f);
    
        gl.glBegin(GL2.GL_QUADS);
        for (int i = 0; i < 8; i++) {
            gl.glVertex3dv(pointArray[i],0);
        }
        gl.glEnd();
    
        gl.glTranslatef(4.0f, 0.0f, 0.0f);
    
        gl.glBegin(GL2.GL_QUAD_STRIP);
        for (int i = 0; i < 8; i++) {
            gl.glVertex3dv(pointArray[i],0);
        }
        gl.glEnd();
    
        gl.glTranslatef(4.0f, 0.0f, 0.0f);
    
        gl.glBegin(GL2.GL_POLYGON);
        for (int i = 0; i < 8; i++) {
            gl.glVertex3dv(pointArray[i],0);
        }
        gl.glEnd();
    }

    /**
     * Called before the OpenGL context is destroyed. Release resource such as buffers.
     */
    public void dispose(GLAutoDrawable drawable) { }

    /** The entry main() method to setup the top-level JFrame with our OpenGL canvas inside */
    public static void main(String[] args) {
        GLCanvas canvas = new Transformasjon13();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        final JFrame frame = new JFrame(); // Swing's JFrame or AWT's Frame
        frame.getContentPane().add(canvas);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//stop program
        frame.setTitle(TITLE);
        frame.pack();
        frame.setVisible(true);
    }
}