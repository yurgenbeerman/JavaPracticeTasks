package edu.services.docs;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lena on 06.03.14.
 */
public class DocumentLifecycle extends ArrayList<String> {
    private boolean isListInUse = false;
    private boolean isFinalized = false;
    private int startStatusIndex;
    private int finalStatusIndex;

    /* we can implement any logic on NextStatus determination
     * let's use simple linear statuses scheme
     */
    public DocumentLifecycle(String[] statuses) {
        for (String s : statuses){
            this.add(s);
        }
        startStatusIndex = 0;
        finalStatusIndex = statuses.length - 1;
    }

    public int getNextStatusIndex(int currentStatusIndex) {
        if (finalStatusIndex != currentStatusIndex){
            return currentStatusIndex + 1;
        } else {
            return currentStatusIndex;
        }
    }

    public int getStartStatusIndex() {
        return startStatusIndex;
    }

    public void setStartStatusIndex(int startStatusIndex) {
        this.startStatusIndex = startStatusIndex;
    }

    public int getFinalStatusIndex() {
        return finalStatusIndex;
    }

    public void setFinalStatusIndex(int finalStatusIndex) {
        this.finalStatusIndex = finalStatusIndex;
    }



    public boolean isListInUse() {
        return isListInUse;
    }

    public void setListInUse(boolean isListInUse) {
        this.isListInUse = isListInUse;
    }

    public boolean isFinalized() {
        return isFinalized;
    }

    public void setFinalized(boolean isFinalized) {
        this.isFinalized = isFinalized;
    }

    @Override
    public void trimToSize() {
        if ((!isListInUse) && (!isFinalized)) {
            super.trimToSize();
        }
    }

    @Override
    public String set(int index, String element) {
        if ((!isListInUse) && (!isFinalized)) {
            return super.set(index, element);
        } else return null;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        if ((!isListInUse) && (!isFinalized)) {
            super.removeRange(fromIndex, toIndex);
        }
    }

    @Override
    public void ensureCapacity(int minCapacity) {
        if ((!isListInUse) && (!isFinalized)) {
            super.ensureCapacity(minCapacity);
        }
    }

    @Override
    public boolean add(String s) {
        if ((!isListInUse) && (!isFinalized)) {
            return super.add(s);
        } else return false;
    }

    @Override
    public void add(int index, String element) {
        if ((!isListInUse) && (!isFinalized)) {
            super.add(index, element);
        }
    }

    @Override
    public String remove(int index) {
        if ((!isListInUse) && (!isFinalized)) {
            return super.remove(index);
        } else return null;
    }

    @Override
    public boolean remove(Object o) {
        if ((!isListInUse) && (!isFinalized)) {
            return super.remove(o);
        } else return false;
    }

    @Override
    public void clear() {
        if ((!isListInUse) && (!isFinalized)) {
            super.clear();
        }
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        if ((!isListInUse) && (!isFinalized)) {
            return super.addAll(c);
        } else return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        if ((!isListInUse) && (!isFinalized)) {
            return super.addAll(index, c);
        } else return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if ((!isListInUse) && (!isFinalized)) {
            return super.removeAll(c);
        } else return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if ((!isListInUse) && (!isFinalized)) {
            return super.retainAll(c);
        } else return false;
    }


}
