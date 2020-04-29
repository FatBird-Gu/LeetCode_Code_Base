package diffi;

interface MountainArray {
    public int get(int index);

    public int length();
}

public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        if (len < 1) {
            return -1;
        }
        return findInMountainArray(target, mountainArr, 0, len - 1, len);
    }

    public int findInMountainArray(int target, MountainArray mountainArr, int l, int r, int len) {
        if (l > r) {
            return -1;
        }
        int mid = (l + r) / 2;
        int midnum = mountainArr.get(mid);
        if (target == midnum) {
            int tmp = findInMountainArray(target, mountainArr, l, mid - 1, len);
            if (tmp == -1) {
                return mid;
            }
        }
        if (target > midnum) {
            int tmp = 0;
            if (mid + 1 < len && midnum > mountainArr.get(mid + 1)) {
                return findInMountainArray(target, mountainArr, l, mid - 1, len);
            } else {
                return findInMountainArray(target, mountainArr, mid + 1, r, len);
            }
        } else {
            if (target < mountainArr.get(l)) {
                return findInMountainArray(target, mountainArr, mid + 1, r, len);
            } else if (target < mountainArr.get(r)) {
                return findInMountainArray(target, mountainArr, l, mid - 1, len);
            } else {
                int tmp = findInMountainArray(target, mountainArr, l, mid - 1, len);
                if (tmp != -1) {
                    return tmp;
                } else {
                    return findInMountainArray(target, mountainArr, mid + 1, r, len);
                }
            }
        }
    }
}
