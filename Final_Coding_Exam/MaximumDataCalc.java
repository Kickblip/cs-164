import java.util.List;

public class MaximumDataCalc extends AbstractDataCalc{
    public MaximumDataCalc(DataSet set) {
        super(set);
    }
    
    @Override
    public String getType() {
       return "MAX";
    }
    
    @Override
    public double calcLine(List<Double> line) {
       double maxVal = 0.0;
       for (int i = 0; i < line.size(); i++) {
        Double item = line.get(i);
          if (item > maxVal) {
             maxVal = item;
          }
       }
       return maxVal;
    }
}