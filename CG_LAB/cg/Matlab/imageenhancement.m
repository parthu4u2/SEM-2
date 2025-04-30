img = imread('peppers.png');
bright_img = img + 50; % Increase brightness

imshowpair(img, bright_img, 'montage');
title('Original Image (Left) and Brightened Image (Right)');