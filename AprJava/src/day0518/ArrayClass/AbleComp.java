package day0518.ArrayClass;

import java.util.Comparator;

class AbleComp implements Comparator<Able> {
	public int compare(Able obj1, Able obj2) {
		int var = 0;

		if (obj1.getTotal() > obj2.getTotal())
			var = 1;
		else if(obj1.getTotal() < obj2.getTotal())
			var = -1;
		return var;
	}
}
