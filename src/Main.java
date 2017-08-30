import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JDialogFis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joshua Raiser
 */
public class Main extends javax.swing.JFrame{

    /**
     * Creates new form Main
     */
    
    FIS fis;
    JDialogFis jdf;
    
    //JFreeChart chart_tempD, chart_tempA, chart_tempS, chart_veloci;
    //ChartPanel chartPanel_tempD, chartPanel_tempA, chartPanel_tempS, chartPanel_veloci;
    
    public Main() {
        initComponents();
                
        // carrega o arquivo fcl
        String arquivo = "src/fcl/arcondicionado.fcl";
        fis = FIS.load(arquivo);
        if( fis == null ) { 
            JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo "+arquivo, "Erro ao abrir arquivo", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        
        pintaGraficos();
    }
    
    public void pintaGraficos()
    {
        /*
        chart_tempD = createChart("Temperatura Desejada", "Temperatura ºC", "Grau de Pertinência", createDatasetTempD());
        chartPanel_tempD = new ChartPanel(chart_tempD);        
        temp_d.setLayout(new BorderLayout());
        temp_d.add(chartPanel_tempD);
        
        chart_tempA = createChart("Temperatura Ambiente", "Temperatura ºC", "Grau de Pertinência", createDatasetTempA());
        chartPanel_tempA = new ChartPanel(chart_tempA);
        temp_a.setLayout(new BorderLayout());
        temp_a.add(chartPanel_tempA);
        
        chart_tempS = createChart("Temperatura de Saída", "Temperatura ºC", "Grau de Pertinência", createDatasetTempS());
        chartPanel_tempS = new ChartPanel(chart_tempS);
        temp_s.setLayout(new BorderLayout());
        temp_s.add(chartPanel_tempS);
        
        chart_veloci = createChart("Velocidade de Saída do Vento", "Escala de Força", "Grau de Pertinência", createDatasetVeloci());
        chartPanel_veloci = new ChartPanel(chart_veloci);
        veloci.setLayout(new BorderLayout());
        veloci.add(chartPanel_veloci);
        */
        jdf = new JDialogFis(fis, fuzzyPanelChart.getWidth()+20, fuzzyPanelChart.getHeight()+40);
        jdf.setVisible(false);
        JPanel pannelChart = jdf.getPanel();
        fuzzyPanelChart.add(pannelChart, BorderLayout.CENTER);
        fuzzyPanelChart.repaint();
        
        this.pack();
    }

    /*
    private DefaultCategoryDataset createDatasetTempD() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // baixo
        dataset.addValue(1, "Baixo", "17");
        dataset.addValue(0.75, "Baixo", "18");
        dataset.addValue(0.5, "Baixo", "19");
        dataset.addValue(0.25, "Baixo", "20");
        dataset.addValue(0, "Baixo", "21");

        // medio
        dataset.addValue(0, "Medio", "19");
        dataset.addValue(0.25, "Medio", "20");
        dataset.addValue(0.5, "Medio", "21");
        dataset.addValue(0.75, "Medio", "21,5");
        dataset.addValue(1, "Medio", "22");
        dataset.addValue(0.75, "Medio", "22,5");
        dataset.addValue(0.5, "Medio", "23");
        dataset.addValue(0.25, "Medio", "24");
        dataset.addValue(0, "Medio", "25");
        
        // alto
        dataset.addValue(0, "Alto", "23");
        dataset.addValue(0.2, "Alto", "24");
        dataset.addValue(0.4, "Alto", "25");
        dataset.addValue(0.6, "Alto", "26");
        dataset.addValue(0.8, "Alto", "27");
        dataset.addValue(1, "Alto", "28");
                
        return dataset;
    }
    
    private DefaultCategoryDataset createDatasetTempA() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // baixo
        dataset.addValue(1, "Baixo", "10");
        dataset.addValue(0.9230, "Baixo", "11");
        dataset.addValue(0.8461, "Baixo", "12");
        dataset.addValue(0.7692, "Baixo", "13");
        dataset.addValue(0.6923, "Baixo", "14");
        dataset.addValue(0.6153, "Baixo", "15");
        dataset.addValue(0.5384, "Baixo", "16");
        dataset.addValue(0.4615, "Baixo", "17");
        dataset.addValue(0.3846, "Baixo", "18");
        dataset.addValue(0.3076, "Baixo", "19");
        dataset.addValue(0.2307, "Baixo", "20");
        dataset.addValue(0.1538, "Baixo", "21");
        dataset.addValue(0.0769, "Baixo", "22");
        dataset.addValue(0, "Baixo", "23");
        
        // medio
        dataset.addValue(0, "Medio", "21");
        dataset.addValue(0.25, "Medio", "22");
        dataset.addValue(0.5, "Medio", "23");
        dataset.addValue(0.75, "Medio", "24");
        dataset.addValue(1, "Medio", "25");
        dataset.addValue(0.75, "Medio", "26");
        dataset.addValue(0.5, "Medio", "27");
        dataset.addValue(0.25, "Medio", "28");
        dataset.addValue(0, "Medio", "29");
        
        // alto
        dataset.addValue(0, "Alto", "27");
        dataset.addValue(0.125, "Alto", "28");
        dataset.addValue(0.25, "Alto", "29");
        dataset.addValue(0.375, "Alto", "30");
        dataset.addValue(0.5, "Alto", "31");
        dataset.addValue(0.625, "Alto", "32");
        dataset.addValue(0.75, "Alto", "33");
        dataset.addValue(0.875, "Alto", "34");
        dataset.addValue(1, "Alto", "35");
        
        return dataset;
    }
    
    private DefaultCategoryDataset createDatasetTempS() {
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       
       // baixo
       dataset.addValue(1, "Baixo", "10");
       dataset.addValue(0.9166, "Baixo", "11");
       dataset.addValue(0.8333, "Baixo", "12");
       dataset.addValue(0.75, "Baixo", "13");
       dataset.addValue(0.6666, "Baixo", "14");
       dataset.addValue(0.5833, "Baixo", "15");
       dataset.addValue(0.5, "Baixo", "16");
       dataset.addValue(0.4166, "Baixo", "17");
       dataset.addValue(0.3333, "Baixo", "18");
       dataset.addValue(0.25, "Baixo", "19");
       dataset.addValue(0.1666, "Baixo", "20");
       dataset.addValue(0.0833, "Baixo", "21");
       dataset.addValue(0, "Baixo", "22");
       
       // medio
       dataset.addValue(0, "Medio", "20");
       dataset.addValue(1, "Medio", "21");
       dataset.addValue(0.8571, "Medio", "22");
       dataset.addValue(0.7142, "Medio", "23");
       dataset.addValue(0.5714, "Medio", "24");
       dataset.addValue(0.4285, "Medio", "25");
       dataset.addValue(0.2857, "Medio", "26");
       dataset.addValue(0.1428, "Medio", "27");
       dataset.addValue(0, "Medio", "28");
       
       // alto
       dataset.addValue(0, "Alto", "26");
       dataset.addValue(0.10, "Alto", "27");
       dataset.addValue(0.21, "Alto", "28");
       dataset.addValue(0.32, "Alto", "29");
       dataset.addValue(0.43, "Alto", "30");
       dataset.addValue(0.54, "Alto", "31");
       dataset.addValue(0.65, "Alto", "32");
       dataset.addValue(0.76, "Alto", "33");
       dataset.addValue(0.87, "Alto", "34");
       dataset.addValue(1, "Alto", "35");
       
       return dataset;
    }
    
    private DefaultCategoryDataset createDatasetVeloci() {
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                     
       // baixo
       dataset.addValue(1, "Baixo", "1");
       dataset.addValue(0.5, "Baixo", "2");
       dataset.addValue(0, "Baixo", "3");
              
       // medio
       dataset.addValue(0, "Medio", "2");
       dataset.addValue(1, "Medio", "3");
       dataset.addValue(0, "Medio", "4");
       
       // alto
       dataset.addValue(0, "Alto", "3");
       dataset.addValue(0.5, "Alto", "4");
       dataset.addValue(1, "Alto", "5");
               
       return dataset;
    }
    */
    /*
    private JFreeChart createChart(String title, String xLegend, String yLegend, DefaultCategoryDataset dataset) {
                
        final JFreeChart chart = ChartFactory.createAreaChart(
            title,             // chart title
            xLegend,               // domain axis label
            yLegend,                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            false,                     // tooltips
            false                     // urls
        );
        
        chart.setBackgroundPaint(Color.WHITE);
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setForegroundAlpha(0.5f);
        
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);
                
        return chart;
    }
    */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        fuzzyButton = new javax.swing.JButton();
        fuzzyButtonSimular = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        temp_a_val = new javax.swing.JSpinner();
        temp_d_val = new javax.swing.JSpinner();
        fv_val_label = new javax.swing.JLabel();
        ts_val_label = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        fuzzyPanelChart = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jPanel9.setPreferredSize(new java.awt.Dimension(886, 152));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        jPanel13.setPreferredSize(new java.awt.Dimension(886, 152));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Especialista - Ar Condicionado Fuzzy");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(950, 604));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 800));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));

        fuzzyButton.setBackground(new java.awt.Color(0, 0, 0));
        fuzzyButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fuzzyButton.setForeground(new java.awt.Color(51, 51, 51));
        fuzzyButton.setText("Executar");
        fuzzyButton.setToolTipText("");
        fuzzyButton.setBorder(null);
        fuzzyButton.setBorderPainted(false);
        fuzzyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fuzzyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fuzzyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuzzyButtonActionPerformed(evt);
            }
        });

        fuzzyButtonSimular.setBackground(new java.awt.Color(0, 0, 0));
        fuzzyButtonSimular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fuzzyButtonSimular.setForeground(new java.awt.Color(51, 51, 51));
        fuzzyButtonSimular.setText("Simular");
        fuzzyButtonSimular.setToolTipText("");
        fuzzyButtonSimular.setBorder(null);
        fuzzyButtonSimular.setBorderPainted(false);
        fuzzyButtonSimular.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fuzzyButtonSimular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fuzzyButtonSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuzzyButtonSimularActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("VELOCIDADE DE SAÍDA DO VENTO (FV)");

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SAÍDAS");

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TEMPERATURA DE SAÍDA (TS)");

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ENTRADAS");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TEMPERATURA DESEJADA (TD)");

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TEMPERATURA AMBIENTE (TA)");

        temp_a_val.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        temp_a_val.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(32.0f), Float.valueOf(5.0f), Float.valueOf(38.0f), Float.valueOf(0.1f)));
        temp_a_val.setNextFocusableComponent(temp_d_val);

        temp_d_val.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        temp_d_val.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(21.0f), Float.valueOf(16.0f), Float.valueOf(30.0f), Float.valueOf(1.0f)));
        temp_d_val.setNextFocusableComponent(temp_a_val);

        fv_val_label.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        fv_val_label.setForeground(new java.awt.Color(255, 255, 255));

        ts_val_label.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        ts_val_label.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(temp_d_val, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(temp_a_val, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fv_val_label, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(ts_val_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(temp_d_val, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(fv_val_label))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(temp_a_val, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(ts_val_label))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fuzzyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fuzzyButtonSimular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fuzzyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fuzzyButtonSimular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setEnabled(false);
        jPanel4.setMaximumSize(new java.awt.Dimension(1200, 800));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Temperatura ºC");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Temperatura ºC");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(196, 196, 196))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Temperatura ºC");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Escala de força de saída do vento");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(133, 133, 133))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        javax.swing.GroupLayout fuzzyPanelChartLayout = new javax.swing.GroupLayout(fuzzyPanelChart);
        fuzzyPanelChart.setLayout(fuzzyPanelChartLayout);
        fuzzyPanelChartLayout.setHorizontalGroup(
            fuzzyPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fuzzyPanelChartLayout.setVerticalGroup(
            fuzzyPanelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fuzzyPanelChartLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fuzzyPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fuzzyPanelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fuzzyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuzzyButtonActionPerformed
        // TODO add your handling code here:
        
        float tempD = (float)temp_d_val.getValue();
        float tempA = (float)temp_a_val.getValue();
        
        // variáveis de entrada
        fis.setVariable("temperatura_desejada", tempD);
        fis.setVariable("temperatura_ambiente", tempA);
        
        fis.evaluate();
        
        float tempS = (float)fis.getVariable("temperatura_saida").getLatestDefuzzifiedValue();
        float veloci = (float)fis.getVariable("velocidade_saida").getLatestDefuzzifiedValue();
        
        ts_val_label.setText(String.format("%.2f", tempS)+" ºC");
        fv_val_label.setText(String.format("%.2f", veloci)+" força do vento");
                            
        fuzzyPanelChart.repaint();
    }//GEN-LAST:event_fuzzyButtonActionPerformed

    private void fuzzyButtonSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuzzyButtonSimularActionPerformed
        // TODO add your handling code here:
        
        Simulacao simulacao = new Simulacao();
        Thread thread = new Thread(simulacao);
        thread.start();
        
    }//GEN-LAST:event_fuzzyButtonSimularActionPerformed
        
    public class Simulacao implements Runnable
    {
        @Override
        public void run() {
            fuzzyButton.setEnabled(false);
            fuzzyButtonSimular.setEnabled(false);

            float tempD = (float)temp_d_val.getValue();
            //float tempA = (float)temp_a_val.getValue();
            
            if((float)temp_a_val.getValue() > tempD)
            {
                for(float tempA = (float)temp_a_val.getValue(); tempA > tempD; tempA-=0.1)
                {            
                    fis.getVariable("temperatura_desejada").setValue(tempD);
                    fis.getVariable("temperatura_ambiente").setValue(tempA);
                    fis.evaluate();

                    float tempS = (float)fis.getVariable("temperatura_saida").getLatestDefuzzifiedValue();
                    float veloci = (float)fis.getVariable("velocidade_saida").getLatestDefuzzifiedValue();
                    ts_val_label.setText(String.format("%.2f", tempS)+" ºC");
                    fv_val_label.setText(String.format("%.2f", veloci)+" força do vento");

                    fuzzyPanelChart.repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao iniciar thread\n"+ex.getMessage(), "Erro ao iniciar simulação", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                }
            }
            else
            {
                for(float tempA = (float)temp_a_val.getValue(); tempA < tempD; tempA+=0.1)
                {            
                    fis.getVariable("temperatura_desejada").setValue(tempD);
                    fis.getVariable("temperatura_ambiente").setValue(tempA);
                    fis.evaluate();

                    float tempS = (float)fis.getVariable("temperatura_saida").getLatestDefuzzifiedValue();
                    float veloci = (float)fis.getVariable("velocidade_saida").getLatestDefuzzifiedValue();
                    ts_val_label.setText(String.format("%.2f", tempS)+" ºC");
                    fv_val_label.setText(String.format("%.2f", veloci)+" força do vento");

                    fuzzyPanelChart.repaint();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao iniciar thread\n"+ex.getMessage(), "Erro ao iniciar simulação", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                }
            }
            

            fuzzyButton.setEnabled(true);
            fuzzyButtonSimular.setEnabled(true);
        }        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            /*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fuzzyButton;
    private javax.swing.JButton fuzzyButtonSimular;
    private javax.swing.JPanel fuzzyPanelChart;
    private javax.swing.JLabel fv_val_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSpinner temp_a_val;
    private javax.swing.JSpinner temp_d_val;
    private javax.swing.JLabel ts_val_label;
    // End of variables declaration//GEN-END:variables
}
