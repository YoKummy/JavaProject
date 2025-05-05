import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("排序演算法視覺化");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.setLocationRelativeTo(null);

            String[] algos = { "Selection Sort", "Merge Sort" };
            JComboBox<String> selector = new JComboBox<>(algos);

            JButton renewBtn = new JButton("Renew");
            JButton runBtn   = new JButton("Run");

            SortPanel panel = new SortPanel(selector, renewBtn);

            renewBtn.addActionListener(e -> panel.resetData());
            runBtn.addActionListener(e -> panel.startSorting());

            frame.setLayout(new BorderLayout());
            JPanel north = new JPanel(new BorderLayout());
            north.add(selector, BorderLayout.EAST);
            frame.add(north, BorderLayout.NORTH);
            frame.add(panel, BorderLayout.CENTER);
            JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
            south.add(renewBtn);
            south.add(runBtn);
            frame.add(south, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    static class SortPanel extends JPanel implements Runnable {
        private final int size = 100;
        private int[] data;
        private volatile boolean sorting = false;
        private final JComboBox<String> selector;
        private final JButton renewBtn;

        public SortPanel(JComboBox<String> selector, JButton renewBtn) {
            this.selector = selector;
            this.renewBtn = renewBtn;
            resetData();
        }

        public void startSorting() {
            if (sorting) return;
            sorting = true;
            renewBtn.setEnabled(false);
            selector.setEnabled(false);
            new Thread(this).start();
        }

        public void resetData() {
            Integer[] temp = new Integer[size];
            for (int i = 0; i < size; i++) temp[i] = i + 1;
            java.util.List<Integer> list = Arrays.asList(temp);
            Collections.shuffle(list);
            data = new int[size];
            for (int i = 0; i < size; i++) data[i] = list.get(i);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth(), h = getHeight(), m = 20;
            g.setColor(Color.BLACK);
            g.drawRect(m, m, w - 2 * m, h - 2 * m);

            if (data == null) return;

            int dotSize = 8;
            int maxVal = size;

            double spacing = (double)(w - 2 * m) / (size - 1);

            for (int i = 0; i < size; i++) 
            {
                int x = m + (int)(i * spacing);
                int scaledHeight = (int) ((double) data[i] / size * (h - 2 * m));
                int y = h - m - scaledHeight;

                g.setColor(Color.BLUE);
                g.fillOval(x, y, 8, 8);
            }

        }

        @Override
        public void run() {
            String algo = (String) selector.getSelectedItem();
            if ("Merge Sort".equals(algo)) {
                mergeSort(0, data.length - 1);
            } else {
                selectionSort();
            }
            sorting = false;
            renewBtn.setEnabled(true);
            selector.setEnabled(true);
            repaint();
        }

        private void selectionSort() {
            int n = data.length;
            for (int i = 0; i < n - 1; i++) {
                int min = i;
                for (int j = i + 1; j < n; j++) {
                    if (data[j] < data[min]) {
                        min = j;
                    }
                }
                int temp = data[i];
                data[i] = data[min];
                data[min] = temp;
                repaint();
                sleep(10);
            }
        }

        private void mergeSort(int left, int right) {
            if (left >= right) return;
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
            repaint();
            sleep(10);
        }

        private void merge(int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int i = left, j = mid + 1, k = 0;

            while (i <= mid && j <= right) {
                if (data[i] <= data[j]) {
                    temp[k++] = data[i++];
                } else {
                    temp[k++] = data[j++];
                }
            }

            while (i <= mid) temp[k++] = data[i++];
            while (j <= right) temp[k++] = data[j++];

            System.arraycopy(temp, 0, data, left, temp.length);
        }

        private void sleep(int ms) {
            try {
                Thread.sleep(ms);
            } catch (InterruptedException ignored) {}
        }
    }
}