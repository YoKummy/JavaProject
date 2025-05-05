import javax.swing.*;
import java.awt.*;

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

            // 自訂畫板
            SortPanel panel = new SortPanel(selector, renewBtn);

            // btn event
            renewBtn.addActionListener(e -> panel.resetData());
            runBtn  .addActionListener(e -> panel.startSorting());

            // 版面配置
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
    	private volatile boolean sorting = false;
        private final JComboBox<String> selector;
        private final JButton renewBtn;

        private int[] data;
        private final int size = 100;

        public SortPanel(JComboBox<String> selector, JButton renewBtn) {
            this.selector = selector;
            this.renewBtn = renewBtn;
            resetData();
        }

        // TODO:按下 Run 執行排序演算法視覺化
        public void startSorting() 
        {
            if (sorting) return;
            sorting = true;
            renewBtn.setEnabled(false);
            selector.setEnabled(false);
            Thread thread = new Thread(this);
            thread.start();
        }

        // TODO:按下 renew 重新生成資料
        public void resetData() 
        {
            Integer[] temp = new Integer[size];
            for(int i = 0; i < size; i++)
            {
                temp[i] = i + 1;
            }

            java.util.List<Integer> list = java.util.Arrays.asList(temp);
            java.util.Collections.shuffle(list);

            data = new int[size];
            for(int i = 0; i < size; i++)
            {
                data[i] = list.get(i);
            }
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int w = getWidth(), h = getHeight(), m = 20;
            g.setColor(Color.BLACK);
            g.drawRect(m, m, w - 2*m, h - 2*m);
            // TODO：繪製圓點            
            // 設定該原點顏色
            g.setColor(Color.BLACK);
            // fillOval(欲繪製的x軸位置, 欲繪製的y軸位置, 長, 寬)
            //g.fillOval(x, y, 8, 8);
        }

        /** 排序執行緒進入點 */
        @Override
        public void run() {
            String algo = (String) selector.getSelectedItem();
            if ("Merge Sort".equals(algo)) {
             //TODO
             mergeSort();
            } else {
             //TODO
             selectionSort();
            }
            // 排序結束後，解鎖並重繪
            sorting = false;
            renewBtn.setEnabled(true);
            selector.setEnabled(true);
            repaint();
        }

        //TODO: selection sort
        private void selectionSort() 
        {
            for (int i = 0; i < data.length - 2; i++)
            {
                int min = i;
                for (int j = i + 1; j < data.length - 1; j++)
                {
                    if(data[j] < data[min])
                    {
                        min = j;  
                    }
                }
                int temp = data[i];
                data[i] = data[min];
                data[min] = temp;
            }
        }

        //TODO: merge sort
        private void mergeSort() 
        {
            if(data.length > 1)
            {
                int mid = data.length / 2;
                int []left = new int [mid];
            }
        }

        /** 簡單延遲 */
        private void sleep(int ms) {
            try { Thread.sleep(ms); }
            catch (InterruptedException ignored) {}
        }
    }
}