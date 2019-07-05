package com.intilled.uvt.model;

import java.util.Objects;

/**
 * Represents a video fragment
 */
public class Fragment {
    private final long startInMillis;
    private final long endInMillis;

    public Fragment(long startInMillis, long endInMillis) {
        this.startInMillis = startInMillis;
        this.endInMillis = endInMillis;
    }

    public long getStartInMillis() {
        return startInMillis;
    }

    public long getEndInMillis() {
        return endInMillis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fragment fragment = (Fragment) o;
        return startInMillis == fragment.startInMillis &&
                endInMillis == fragment.endInMillis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startInMillis, endInMillis);
    }
}
