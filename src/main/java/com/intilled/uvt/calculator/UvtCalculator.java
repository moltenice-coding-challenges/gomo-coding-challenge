package com.intilled.uvt.calculator;

import com.intilled.uvt.model.Fragment;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UvtCalculator {
    public long calculateUvt(Set<Fragment> fragments) {
        long uvt = 0;
        if (CollectionUtils.isNotEmpty(fragments)) {
            List<Fragment> sortedFragments = fragments.stream()
                    .sorted(Comparator.comparing(Fragment::getStartInMillis))
                    .collect(Collectors.toList());
            sortedFragments.removeIf(fragment -> fragment.isSubsetOfAnElementIn(fragments));

            ListIterator<Fragment> iterator = sortedFragments.listIterator();
            while (iterator.hasNext()) {
                Fragment fragment = iterator.next();
                long start = fragment.getStartInMillis();
                long end = fragment.getEndInMillis();
                if (iterator.hasNext()) {
                    Fragment nextFragment = sortedFragments.get(iterator.nextIndex());
                    long nextStart = nextFragment.getStartInMillis();
                    if (nextStart < end) {
                        end = nextStart;
                    }
                }
                uvt += end - start;
            }
        }
        return uvt;
    }
}
