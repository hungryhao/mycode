package com.hungry.leetcode;

import java.util.List;
import java.util.ListIterator;

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			i++;
		}
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			/*if (newInterval.start > intervals.get(i).start) {
				newInterval.start = intervals.get(i).start;
			}
			if (newInterval.end < intervals.get(i).end) {
				newInterval.end = intervals.get(i).end;
			}*/
			newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start), 
					Math.max(newInterval.end, intervals.get(i).end));
			intervals.remove(i);
		}
		intervals.add(i, newInterval);
		return intervals;
	}
	
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		ListIterator<Interval> i = intervals.listIterator();
        Interval in;
        while (i.hasNext()) {
            in = i.next();
            if (in.end<newInterval.start) {
            	continue;
            }
            if (in.start <= newInterval.end) {
            	newInterval = new Interval(Math.min(newInterval.start, in.start), 
    					Math.max(newInterval.end, in.end));
                i.remove();
            } else {
                i.previous();
                break;
            }
        }
		i.add(newInterval);
		return intervals;
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
