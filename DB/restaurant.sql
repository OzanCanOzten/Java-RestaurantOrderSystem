-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 17 Kas 2018, 11:01:05
-- Sunucu sürümü: 10.1.36-MariaDB
-- PHP Sürümü: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `restaurant`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  `table_no` int(100) DEFAULT NULL,
  `order_count` int(3) NOT NULL,
  `order_price` double NOT NULL,
  `order_time` datetime NOT NULL,
  `prepare_status` varchar(3) COLLATE utf8_turkish_ci NOT NULL,
  `delivery_status` varchar(3) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `orders`
--

INSERT INTO `orders` (`order_id`, `product_id`, `person_id`, `table_no`, `order_count`, `order_price`, `order_time`, `prepare_status`, `delivery_status`) VALUES
(5, 4, 4, 6, 3, 9, '2018-11-16 23:49:21', 'W', 'W'),
(6, 6, 4, 8, 4, 40, '2018-11-16 23:53:06', 'W', 'W'),
(7, 4, 4, 9, 9, 27, '2018-11-16 23:54:34', 'W', 'W'),
(8, 6, 4, 3, 3, 30, '2018-11-16 23:57:30', 'F', 'F'),
(9, 3, 4, 3, 9, 225, '2018-11-17 08:31:12', 'F', 'F');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personel`
--

CREATE TABLE `personel` (
  `person_id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `surname` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_turkish_ci DEFAULT NULL,
  `password` varchar(10) COLLATE utf8_turkish_ci DEFAULT NULL,
  `authority` varchar(10) COLLATE utf8_turkish_ci NOT NULL,
  `phone` bigint(10) NOT NULL,
  `email` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `status` varchar(3) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `personel`
--

INSERT INTO `personel` (`person_id`, `name`, `surname`, `username`, `password`, `authority`, `phone`, `email`, `status`) VALUES
(3, 'Admin', 'Admin', 'Admin', 'Admin', 'A', 5001234567, 'admin@mail.com', 'W'),
(4, 'Garson', 'Garson', 'Garson', 'Garson', 'G', 5009876543, 'garson@mail.com', 'W'),
(5, 'Aşçı', 'Mutfak', 'Mutfak', 'Mutfak', 'M', 500987651, 'mutfak@mail.com', 'W');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `product_count` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_count`, `price`) VALUES
(1, 'Ürün1', 20, 5),
(3, 'Ürün2', 30, 25),
(4, 'Ürün3', 10, 3),
(6, 'Deneme1', 30, 10);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Tablo için indeksler `personel`
--
ALTER TABLE `personel`
  ADD PRIMARY KEY (`person_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Tablo için indeksler `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `personel`
--
ALTER TABLE `personel`
  MODIFY `person_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
