public class LinkedIntList implements IntList {

    Node head;

    public LinkedIntList() {
        head = new Node();
        head = null;
    }


    @Override
    public void add(int value) {


        Node ptr = new Node();
        ptr.data = value;
        ptr.next = null;


        if (head == null)
            head = ptr;

        else {
            Node tmp = head;

            while (tmp.next != null) {
                tmp = tmp.next;
            }

            tmp.next = ptr;

        }


    }

    @Override
    public int size() {

        Node tmp = head;
        int counter = 0;

        while (tmp != null) {
            counter += 1;
            tmp = tmp.next;
        }


        return counter;
    }

    @Override
    public int get(int index) {


        Node tmp = head;

        int i = 0;

        if (index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }


        while (tmp != null) {

            if (i == index) {
                return tmp.data;
            }


            tmp = tmp.next;
            i++;

        }


        return -1;
    }

    @Override
    public int indexOf(int value) {

        Node tmp = head;
        int i = 0;

        while (tmp != null) {

            if (tmp.data == value) return i;

            tmp = tmp.next;
            i += 1;
        }


        return -1;
    }

    @Override
    public void add(int index, int value) {


      

        Node ptr = new Node();
        ptr.data = value;


        if (index < 0 || size() < index) throw new IndexOutOfBoundsException();

        Node tmp;


        if (index == 0) {
            ptr.next = head;
            head = ptr;
        }


        int counter = 0;
        tmp = head;


        while (tmp != null) {


          
            if (tmp.next == null) {
                if (counter == index) {
                    ptr.next = null;
                    tmp.next = ptr;
                }
            }


            if ((counter + 1) == index) {

                ptr.next = tmp.next;
                tmp.next = ptr;

                return;
            }

            counter += 1;

            tmp = tmp.next;

        }


    }

    @Override
    public void remove(int index) {






        Node tmp = head;

        int counter = 0;

        while (tmp.next != null) {

            if (index == 0) {
             
                head = head.next;
                return;
            }

            if (tmp.next.next == null) {
                if ((counter + 1) == index) {
                    tmp.next.next = null;

                    return;
                }
            }


            if (counter + 1 == index) {
                tmp.next = tmp.next.next;
            }


            counter += 1;

            tmp = tmp.next;
        }


    }

    @Override
    public void insertList(int index, LinkedIntList list) {


        if (index > this.size()) throw new ArrayIndexOutOfBoundsException();


        Node tmp1, tmp2;


        tmp1 = this.head;
        tmp2 = list.head;

        while (tmp2.next != null) {

            tmp2 = tmp2.next;
        }


        int i = 0;

        while ((i + 1) != index) {

            tmp1 = tmp1.next;
            i++;

        }

        Node tmp3 = tmp1.next;

        tmp1.next = list.head;

        tmp2.next = tmp3;


    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;


        if (!(obj instanceof LinkedIntList)) return false;


        LinkedIntList list = (LinkedIntList) obj;


        Node tmp1, tmp2;

        tmp1 = list.head;
        tmp2 = this.head;

        if (list.size() != this.size()) return false;


        while (tmp1 != null && tmp2 != null) {

            if (tmp1.data != tmp2.data) {
                return false;
            }

            tmp1 = tmp1.next;
            tmp2 = tmp2.next;

        }

        return true;
    }

    @Override
    public String toString() {

        String result = "";

        Node tmp = head;

        boolean flag = true;

        while (tmp != null) {
            if (flag) {
                result += "[" + tmp.data;
                flag = false;
            } else
                result += ", " + tmp.data;


            tmp = tmp.next;

        }

        result += "]";

        return result;
    }
}