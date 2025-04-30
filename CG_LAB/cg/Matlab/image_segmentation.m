img = imread('cameraman.tif');
threshold = 100;
binary_img = img > threshold;

imshow(binary_img);
title('Segmented Image (Thresholding)');