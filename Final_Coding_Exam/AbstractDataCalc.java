import java.util.List;

public abstract class AbstractDataCalc {
    DataSet set;
    double[] calculations;
    
    public AbstractDataCalc(DataSet set) {
       setAndRun(set);
    }
    
    public void setAndRun(DataSet set) {
       if (set != null) {
          this.set = set;
          runCalculations(set);
       }
    }
    
    private void runCalculations(DataSet set) {
        calculations = new double[set.rowCount()];
        for (int i = 0; i < set.rowCount(); i++) {
            calculations[i] = calcLine(set.getRow(i));
        }
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Dataset Results (Method: " + getType() + ")\n";
        for (int i = 0; i < calculations.length; i++) {
            ret += "Row " + (i + 1) + ": " + String.format("%.1f", calculations[i]) + "\n";
        }
        return ret;
    }
    
    public abstract String getType();
    public abstract double calcLine(List<Double> line);
 }