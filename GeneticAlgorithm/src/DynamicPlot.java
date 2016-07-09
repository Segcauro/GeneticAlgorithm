import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A demonstration application showing a time series chart where you can dynamically add
 * (random) data by clicking on a button.
 *
 */
public class DynamicPlot extends ApplicationFrame{

    /** The time series data. */
    private XYSeries series;

    public DynamicPlot(final String title) {

        super(title);
        this.series = new XYSeries("Fittest of Generation", true, true);
        final XYSeriesCollection dataset = new XYSeriesCollection(this.series);
        final JFreeChart chart = createChart(dataset);
//fgjdfzhjsghddsz
        final ChartPanel chartPanel = new ChartPanel(chart);
        final JButton saveImage = new JButton("Save Image");
        final JPanel content = new JPanel(new BorderLayout());
        saveImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedImage image = chart.createBufferedImage(720,576);
				int index = 1;
				boolean imageSafed = false;
				while(imageSafed == false){
					File outputfile = new File("GeneticAlgorithmGraph_" + index +".png");
			        if(!outputfile.exists()) { 
			        	try {
							ImageIO.write(image, "png", outputfile);
							imageSafed = true;
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        }else{
			        	index++;
			        }
				}
			}
		});
        content.add(chartPanel);
        content.add(saveImage, BorderLayout.SOUTH);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 350));
        setContentPane(content);

    }

    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createXYLineChart(
            "Genetic Algorithm", 
            "Generation", 
            "Fitness",
            dataset,
            PlotOrientation.VERTICAL,
            true,true,false
        );
        final XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis = plot.getRangeAxis(); 
        return result;
    }
	
    public void plot(int gerneration, double fitness){
         this.series.add(gerneration, fitness);
    }
}