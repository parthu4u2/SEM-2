img = imread('peppers.png');
small_img = imresize(img, 0.5); % Compress (reduce size)
big_img = imresize(small_img, 2); % Resize back to original

imshowpair(img, big_img, 'montage');
title('Original Image (Left) and Compressed-Reconstructed Image (Right)');