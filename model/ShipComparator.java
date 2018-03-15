package model;
import java.util.Comparator;

//this class defines the way of comparing ships (by the decreasing speed)

public class ShipComparator implements Comparator<ClassOfResults> {
	@Override
	public int compare(ClassOfResults s1, ClassOfResults s2) {
		if (s1.getHours() >= s2.getHours())
			return 1;
		else
			return -1;
	}
}
