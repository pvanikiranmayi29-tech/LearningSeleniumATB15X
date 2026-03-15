package com.thetestingacademy.ex08_SVG_Elements;

public class Lab29_SVG_explain {

    // SVG is nothing but a type of image
    //Scalable Vector Graphics
    //XML based language to create 2-D graphics/images with animation and interactivity
    //Uses geometrical figures to draw an image
    //also these are used because when a similar image is created with .png - the size would be 25KB
    //and if it saved as .jpeg - the size could be 53KB and same image with svg would be 9KB
    //so it takes less memory
    //and the major imp concept of svg is - how much ever user tries to zoom in - the image won't pixelate
    //like the search button in the Flipkart searchbar
    //sometimes a remember me - which looks like a checkbox, but it is a square svg
    //it is created by using a svg circle and svg line - which looks like a magnifying glass
    //and to find these elements we cannot use the img or other tags
    //we need to find them with the svg tag

    //we will have <svg> </svg? tags
    //under <svg> - we have multiple other tags which comes
    //<g> - which means geometry
    //<circle>
    //<polygon>
    //<path>
    //and so on...

    //to find the xpath of svg - we use local-name() or name()
    // xpath will be //*[local-name()='svg'] or //*[name()='svg'] - here //* means find all
    //generally we use //*[local-name()='svg']
    //and this gives list of elements on the screen



}
