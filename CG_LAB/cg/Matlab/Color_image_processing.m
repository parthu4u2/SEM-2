img = imread('peppers.png');

red = img(:,:,1);
green = img(:,:,2);
blue = img(:,:,3);

subplot(2,2,1); imshow(img); title('Original');
subplot(2,2,2); imshow(red); title('Red Channel');
subplot(2,2,3); imshow(green); title('Green Channel');
subplot(2,2,4); imshow(blue); title('Blue Channel');