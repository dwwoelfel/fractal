import org.opensourcephysics.controls.*;
import org.opensourcephysics.display.*;
import org.opensourcephysics.frames.PlotFrame;

public class FractalApp extends AbstractSimulation {
    PlotFrame frame = new PlotFrame("x", "y", "Hennon's Map");
    double x,y,rdn, temp;
    
    double[] a = new double[] {0.90, 0.26, 0.26, 0.00};
    double[] b = new double[] {-0.01, 0.26,-0.26, 0.00};
    double[] e = new double[] {0.00, 0.00, 0.00, 0.00};
    double[] c = new double[] {.01, -0.26, .26, 0.00};
    double[] d = new double[] {0.90, 0.26, 0.26, 0.25};
    double[] f = new double[] {0.90, 0.18, 0.15, 0.00};

    public void reset() {
        frame.setPreferredMinMax(-5, 5, -1, 10);
        frame.setSize(600, 600);
        frame.setMaximumPoints(2,1000000000);
        frame.setConnected(false);
        frame.setMarkerSize(2,0);

        initialize();
    }

    public void initialize() {
        x = 0.5;
        y = 0.5;
    }
    
    public void transformation(int i){
        temp = a[i]*x + b[i]*y +e[i];
        y = c[i]*x + d[i]*y + f[i];
        x = temp;
    }

    protected void doStep() {
        for(int n = 0; n < 40000; n++){
            rdn=Math.random();
            if(rdn<0.65){ transformation(0);}
            else if (rdn<0.80){ transformation(1);}
            else if (rdn<0.90){ transformation(2);}
            else { transformation(3);}
            if (n > 30){
                frame.append(2, x, y);
            }
        }
    }

    public static void main(String[] args) {
        SimulationControl.createApp(new FractalApp());
    }
}
