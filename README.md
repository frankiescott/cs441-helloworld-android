# cs441-helloworld-android
This application is an extention of the stock 'Hello World' template provided by Android studio.

The bottom of the application has a stock floating action button that came with the 'Hello World' template, but was editted to display the text, "You clicked the floating action button!" within the application's snackbar. To the left of the floating action button is another button that brings the user to a second activity, editted to display a fade-out/fade-in animation, that houses the text 'Hello World!' in a large font. Also within the second activity is a button the user can press to return to the main activity. 

The middle of the application houses a toggle button that can swap the main text view between 'Hello World' and 'Goodbye World' depending on the toggle's state. I then placed floating action buttons on each side of the toggle for increasing or decreasing the view's text size.

Above the toggle is an empty button, and when pressed, 'Hello World' replaces the button's initial empty text field.  

The next ascending layer of the layout has a text view that states, "Who do you want to say hello to?" next to a button labeled 'Say Hello!' Underneath the text view is an edit text field in which the user can enter a name, and upon pressing the corresponding button, the text view changes to "Hello |input|!"

The final ascending layer of the layout displays the X and Y coordinates when the user touches a place on the screen within the application, and displays if the user's touch input is directed up or down. 

Meta goals for this project involve getting comfortable with Android Studio and the documentation for Android development. From a development standpoint, my goal was to get comfortable with implementing widgets on the screen and writing code to allow them to interact with each other. I also wanted to develop a basic understanding of how to organize the widgets within the application using LinearLayouts and the built-in content design feature.

When working on this project, I ran into some expected issues being new to Android Studio and Android development in general. I mistakenly dumped all application content into `activity_main.xml` but learned that `content_main.xml` should contain the user interface and is imported into `activity_main.xml` When attempting to apply the fade-out/fade-in animation between each of the two activities, the application was crashing and I learned how activities are initialized and where to intialize the animation request. In order to get comfortable with the organizational layout of the application, I repeatedly supplied outlier values to certain XML attributes to learn what certain attributes are responsible for and how do varied inputs alter the display.