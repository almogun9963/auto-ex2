package Drone;

public class PID {
    private final double p;
    private final double i;
    private final double d;
    private double error;
    private double sumIntegral;

    public PID(double p, double i, double d, double dt) {
        this.p = p;
        this.i = i;
        this.d = d;
        this.error = 0;
        this.sumIntegral = 0;
    }

    public double control(double current_error, double dt) {
        this.sumIntegral += this.i * current_error * dt;
        double diff = (current_error-this.error)/dt;
        double result = this.p * current_error + this.sumIntegral + this.d * diff;
        this.error = current_error;
        return result;
    }
}