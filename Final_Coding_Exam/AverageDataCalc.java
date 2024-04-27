import java.util.List;

public class AverageDataCalc extends AbstractDataCalc{
    public AverageDataCalc(DataSet set) {
        super(set);
    }

    @Override
    public String getType() {
       return "AVERAGE";
    }
    
    @Override
    public double calcLine(List<Double> line) {
       double sum = 0;
       int count = 0;
       for (int i = 0; i < line.size(); i++) {
            Double item = line.get(i);
          sum += item;
          count++;
       }
       return sum / count;
    }
}