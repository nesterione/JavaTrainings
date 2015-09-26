package gl.balls;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import static com.jogamp.opengl.GL.*;
import static com.jogamp.opengl.GL.GL_DEPTH_BUFFER_BIT;
import static com.jogamp.opengl.GL.GL_TRIANGLES;
import static com.jogamp.opengl.GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT;
import static com.jogamp.opengl.fixedfunc.GLLightingFunc.GL_SMOOTH;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_MODELVIEW;
import static com.jogamp.opengl.fixedfunc.GLMatrixFunc.GL_PROJECTION;

/**
 * Предупреждение: Я осознаю второй смысл Balls.
 */
@SuppressWarnings("serial")
public class Balls extends GLCanvas implements GLEventListener {
    // Define constants for the top-level container
    private static String TITLE = "Balls";  // window's title
    private static final int CANVAS_WIDTH = 640;  // width of the drawable
    private static final int CANVAS_HEIGHT = 480; // height of the drawable
    private static final int FPS = 60; // animator's target frames per second

    /** The entry main() method to setup the top-level container and animator */
    public static void main(String[] args) {

        // Run the GUI codes in the event-dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create the OpenGL rendering canvas
                // TODO ff
                Balls b = new Balls();

                GLCanvas canvas = b;

                canvas.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // TODO координаты преобразовывать в координаты GL

                        //System.out.println(e.getX() +" "+ e.getY());
                        float height = (( (canvas.getHeight()- e.getY())*6f)/canvas.getHeight());
                        float x = ((e.getX()*6f)/canvas.getWidth());

                        b.balls.add(new Ball(height,x));


                    }
                });

                canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

                // Create a animator that drives canvas' display() at the specified FPS.
                final FPSAnimator animator = new FPSAnimator(canvas, FPS, true);

                // Create the top-level container
                final JFrame frame = new JFrame(); // Swing's JFrame or AWT's Frame
                frame.getContentPane().add(canvas);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        // Use a dedicate thread to run the stop() to ensure that the
                        // animator stops before program exits.
                        new Thread() {
                            @Override
                            public void run() {
                                if (animator.isStarted()) animator.stop();
                                System.exit(0);
                            }
                        }.start();
                    }
                });
                frame.setTitle(TITLE);
                frame.pack();
                frame.setVisible(true);
                animator.start(); // start the animation loop
            }
        });
    }

    // Setup OpenGL Graphics Renderer

    private GL2 gl;
    private GLU glu;  // for the GL Utility
    private float anglePyramid = 0;    // rotational angle in degree for pyramid
    private float speedPyramid = 2.0f; // rotational speed for pyramid
    private float speedCube = -1.5f;   // rotational speed for cube

    /** Constructor to setup the GUI for this Component */
    public Balls() {
        this.addGLEventListener(this);
    }

    // ------ Implement methods declared in GLEventListener ------

    /**
     * Called back immediately after the OpenGL context is initialized. Can be used
     * to perform one-time initialization. Run only once.
     */
    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();      // get the OpenGL graphics context
        glu = new GLU();                         // get GL Utilities
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // set background (clear) color
        gl.glClearDepth(1.0f);      // set clear depth value to farthest
        gl.glEnable(GL_DEPTH_TEST); // enables depth testing
        gl.glDepthFunc(GL_LEQUAL);  // the type of depth test to do
        gl.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST); // best perspective correction
        gl.glShadeModel(GL_SMOOTH); // blends colors nicely, and smoothes out lighting

        createObjects();
        balls.add(new Ball(4, 1.6f));
    }

    /**
     * Call-back handler for window re-size event. Also called when the drawable is
     * first set to visible.
     */
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context

        if (height == 0) height = 1;   // prevent divide by zero
        float aspect = (float)width / height;

        // Set the view port (display area) to cover the entire window
        gl.glViewport(0, 0, width, height);

        // Setup perspective projection, with aspect ratio matches viewport
        gl.glMatrixMode(GL_PROJECTION);  // choose projection matrix
        gl.glLoadIdentity();             // reset projection matrix
        glu.gluPerspective(45.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar

        // Enable the model-view transform
        gl.glMatrixMode(GL_MODELVIEW);
        gl.glLoadIdentity(); // reset
    }

    /**
     * Called back by the animator to perform rendering.
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
        gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear color and depth buffers

       /* // ----- Render the Pyramid -----
        gl.glLoadIdentity();                 // reset the model-view matrix
        gl.glTranslatef(-1.6f, 0.0f, -6.0f); // translate left and into the screen
        gl.glRotatef(anglePyramid, -0.2f, 1.0f, 0.0f); // rotate about the y-axis

        gl.glBegin(GL_TRIANGLES); // of the pyramid

        // Font-face triangle
        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
        gl.glVertex3f(1.0f, -1.0f, 1.0f);

        // Right-face triangle
        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
        gl.glVertex3f(1.0f, -1.0f, 1.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
        gl.glVertex3f(1.0f, -1.0f, -1.0f);

        // Back-face triangle
        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);

        // Left-face triangle
        gl.glColor3f(1.0f, 0.0f, 0.0f); // Red
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f); // Blue
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
        gl.glVertex3f(-1.0f, -1.0f, 1.0f);

        gl.glEnd(); // of the pyramid
*/
        gl.glColor3f(0.0f, 1.0f, 0.0f); // Green
        for(Ball ball: balls) {
            gl.glLoadIdentity();                // reset the current model-view matrix

            //gl.glTranslatef(1.6f, -3.0f, -7.0f); // translate right and into the screen

            gl.glTranslatef(ball.getX()-SCREEN_HEIGHT, ball.getHeight()-SCREEN_HEIGHT, -7.0f); // translate right and into the screen

            if(ball.getVelocity()>0.001) {
                gl.glRotatef(anglePyramid, 1.0f, 1.0f, 1.0f); // rotate about the x, y and z-axes
            }
            ball.updatePosition(System.currentTimeMillis());
            //gl.glPushMatrix();
            // TODO -radius
            //gl.glTranslated(0.0, 0.0, -4);
//        glTranslatef(gameContext.ball.x,gameContext.ball.y,gameContext.ball.z);
//        gameContext.moveBall();
            gl.glIndexi(BLUE_INDEX);
            gl.glCallList(BALL);
            //gl.glPopMatrix();
        }
        // Update the rotational angle after each refresh.
        anglePyramid += speedPyramid;
    }

    java.util.List<Ball> balls = new ArrayList<>();

    final float SCREEN_HEIGHT = 3f;
    final int BLUE_INDEX = 16;

    final int BALL = 1;
    private void createObjects() {

        GLUquadric quadObj;

        gl.glNewList(BALL, GL2.GL_COMPILE);
        quadObj = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(quadObj, glu.GLU_LINE);

        // TODO
        glu.gluSphere(quadObj, RADIUD, 16, 16);
        gl.glEndList();
    }


    final float RADIUD = 0.2f;
    /**
     * Called back before the OpenGL context is destroyed. Release resource such as buffers.
     */
    @Override
    public void dispose(GLAutoDrawable drawable) { }
}