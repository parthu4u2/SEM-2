img = imread('text.png');
se = strel('square', 3); % Square structuring element
dilated_img = imdilate(img, se);

imshowpair(img, dilated_img, 'montage');
title('Original Image (Left) and Dilated Image (Right)');