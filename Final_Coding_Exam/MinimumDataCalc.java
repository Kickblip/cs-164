import java.util.List;

public class MinimumDataCalc extends AbstractDataCalc{
    public MinimumDataCalc(DataSet set) {
        super(set);
    }
    
    @Override
    public String getType() {
       return "MIN";
    }
    
    @Override
    public double calcLine(List<Double> line) {
       double minVal = 100000000.0;
       for (int i = 0; i < line.size(); i++) {
        Double item = line.get(i);
          if (item < minVal) {
             minVal = item;
          }
       }
       return minVal;
    }
}