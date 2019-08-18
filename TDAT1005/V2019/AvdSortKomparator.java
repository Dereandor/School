package V2019;

import java.util.Comparator;

public class AvdSortKomparator implements Comparator<Avdeling> {

  @Override
  public int compare(Avdeling avdeling1, Avdeling avdeling2) {
	 
    if (avdeling1.getAnsatte().size()==avdeling2.getAnsatte().size()) {
      return 0;
    } else if (avdeling1.getAnsatte().size() < avdeling2.getAnsatte().size()) {
      return -1;
    } else {
      return 1;
    }
  }
}