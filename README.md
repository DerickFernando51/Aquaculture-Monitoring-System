# Aquaculture
The aquaculture monitoring system is a system that measures the conditions of aquaculture in environments such as shrimp farming tanks. The three parameters that are tracked are the temperature, TDS and pH. I was responsible for developing a mobile application to monitor the data captured by this system.

The mobile application was created in Android Studio IDE using Java programming language and XML. Figures 1 to 6 show the layout of the activities of this application. Each activity has a seperate Java and XML file.

                       
Figure 2.21 Splashscreen                 Figure 2.22 Temperature                  Figure 2.23 TDS slide 
              activity 			  slide screen activity			    screen activity
              
       Figure 2.24 pH slide                     Figure 2.25 Main activity              Figure 2.26 Temperature 
           screen activity 			 			 	        graph activity (Portrait)


In order to make it easier to analyze the graphs, landscape layout qualifiers were added to the main and graph activity pages as shown in figure 2.27 and 2.28.

 
Figure 2.27 Main activity (Landscape)


 
Figure 2.28 Temperature graph activity (Landscape)




I also added alert dialogs to create an alert if any of the three parameters went above a predefined nominal value. This is illustrated in figure 2.29

 
Figure 2.29 Alert dialog
 
Figure 2.30 Aquaculture monitoring system application activity flow

Figure 2.30 details how the Aquaculture application was structured and how users could navigate between activities using buttons.









