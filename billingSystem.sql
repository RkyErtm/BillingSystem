PGDMP                         {         
   mydatabase    14.7    14.7                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16412 
   mydatabase    DATABASE     g   CREATE DATABASE mydatabase WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE mydatabase;
                postgres    false            �            1259    16454    Kategoriler    TABLE     W   CREATE TABLE public."Kategoriler" (
    "Id" integer NOT NULL,
    ad text NOT NULL
);
 !   DROP TABLE public."Kategoriler";
       public         heap    postgres    false            �            1259    16453    Categories_Id_seq    SEQUENCE     �   ALTER TABLE public."Kategoriler" ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Categories_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    212            �            1259    16505 	   Faturalar    TABLE     �   CREATE TABLE public."Faturalar" (
    "faturaId" integer NOT NULL,
    "urunId" integer NOT NULL,
    "musteriId" integer NOT NULL,
    adet integer NOT NULL,
    toplam integer NOT NULL,
    "faturaTipi" text NOT NULL
);
    DROP TABLE public."Faturalar";
       public         heap    postgres    false            �            1259    16504    Faturalar_faturaId_seq    SEQUENCE     �   ALTER TABLE public."Faturalar" ALTER COLUMN "faturaId" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Faturalar_faturaId_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    218            �            1259    16414    Kullanicilar    TABLE     �   CREATE TABLE public."Kullanicilar" (
    "Id" integer NOT NULL,
    ad text NOT NULL,
    soyad text NOT NULL,
    sifre text NOT NULL,
    email text NOT NULL,
    rol text DEFAULT 'c'::"char"
);
 "   DROP TABLE public."Kullanicilar";
       public         heap    postgres    false            �            1259    16476 
   Musteriler    TABLE     �   CREATE TABLE public."Musteriler" (
    id integer NOT NULL,
    ad text NOT NULL,
    soyad text NOT NULL,
    email text NOT NULL,
    adres text NOT NULL,
    cinsiyet text,
    "tcNo" text NOT NULL,
    telefon text NOT NULL
);
     DROP TABLE public."Musteriler";
       public         heap    postgres    false            �            1259    16475    Musteriler_id_seq    SEQUENCE     �   ALTER TABLE public."Musteriler" ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Musteriler_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            �            1259    16462    Urunler    TABLE     �   CREATE TABLE public."Urunler" (
    "Id" integer NOT NULL,
    "urunAdi" text NOT NULL,
    fiyat integer NOT NULL,
    adet integer NOT NULL,
    aciklama text,
    kategori integer
);
    DROP TABLE public."Urunler";
       public         heap    postgres    false            �            1259    16461    Urunler_Id_seq    SEQUENCE     �   ALTER TABLE public."Urunler" ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Urunler_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    214            �            1259    16413    Users_Id_seq    SEQUENCE     �   ALTER TABLE public."Kullanicilar" ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Users_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    210                      0    16505 	   Faturalar 
   TABLE DATA           d   COPY public."Faturalar" ("faturaId", "urunId", "musteriId", adet, toplam, "faturaTipi") FROM stdin;
    public          postgres    false    218   �"                 0    16454    Kategoriler 
   TABLE DATA           1   COPY public."Kategoriler" ("Id", ad) FROM stdin;
    public          postgres    false    212   �"       	          0    16414    Kullanicilar 
   TABLE DATA           L   COPY public."Kullanicilar" ("Id", ad, soyad, sifre, email, rol) FROM stdin;
    public          postgres    false    210   ##                 0    16476 
   Musteriler 
   TABLE DATA           ^   COPY public."Musteriler" (id, ad, soyad, email, adres, cinsiyet, "tcNo", telefon) FROM stdin;
    public          postgres    false    216   $                 0    16462    Urunler 
   TABLE DATA           U   COPY public."Urunler" ("Id", "urunAdi", fiyat, adet, aciklama, kategori) FROM stdin;
    public          postgres    false    214   �$                  0    0    Categories_Id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."Categories_Id_seq"', 5, true);
          public          postgres    false    211                       0    0    Faturalar_faturaId_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public."Faturalar_faturaId_seq"', 4, true);
          public          postgres    false    217                       0    0    Musteriler_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public."Musteriler_id_seq"', 6, true);
          public          postgres    false    215                       0    0    Urunler_Id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public."Urunler_Id_seq"', 8, true);
          public          postgres    false    213                       0    0    Users_Id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public."Users_Id_seq"', 18, true);
          public          postgres    false    209            t           2606    16460    Kategoriler Categories_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public."Kategoriler"
    ADD CONSTRAINT "Categories_pkey" PRIMARY KEY ("Id");
 I   ALTER TABLE ONLY public."Kategoriler" DROP CONSTRAINT "Categories_pkey";
       public            postgres    false    212            {           2606    16511    Faturalar Faturalar_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public."Faturalar"
    ADD CONSTRAINT "Faturalar_pkey" PRIMARY KEY ("faturaId");
 F   ALTER TABLE ONLY public."Faturalar" DROP CONSTRAINT "Faturalar_pkey";
       public            postgres    false    218            y           2606    16482    Musteriler Musteriler_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public."Musteriler"
    ADD CONSTRAINT "Musteriler_pkey" PRIMARY KEY (id);
 H   ALTER TABLE ONLY public."Musteriler" DROP CONSTRAINT "Musteriler_pkey";
       public            postgres    false    216            v           2606    16468    Urunler Urunler_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public."Urunler"
    ADD CONSTRAINT "Urunler_pkey" PRIMARY KEY ("Id");
 B   ALTER TABLE ONLY public."Urunler" DROP CONSTRAINT "Urunler_pkey";
       public            postgres    false    214            r           2606    16419    Kullanicilar Users_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public."Kullanicilar"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY ("Id");
 E   ALTER TABLE ONLY public."Kullanicilar" DROP CONSTRAINT "Users_pkey";
       public            postgres    false    210            w           1259    16474    fki_kategoriId_foreign    INDEX     R   CREATE INDEX "fki_kategoriId_foreign" ON public."Urunler" USING btree (kategori);
 ,   DROP INDEX public."fki_kategoriId_foreign";
       public            postgres    false    214            |           2606    16469    Urunler kategoriId_foreign    FK CONSTRAINT     �   ALTER TABLE ONLY public."Urunler"
    ADD CONSTRAINT "kategoriId_foreign" FOREIGN KEY (kategori) REFERENCES public."Kategoriler"("Id") NOT VALID;
 H   ALTER TABLE ONLY public."Urunler" DROP CONSTRAINT "kategoriId_foreign";
       public          postgres    false    212    3188    214               ;   x�3�4�4�4�4420�N,9���|.#�HY̘��8M�A�LA�Mb1z\\\ ׫j         <   x�3�t9���|����\.#��s�K�cN�ۄ325/3'��˔�p{b^I"W� ���      	   �   x�u�=n�0��S�A���ݒ�@��Y(�H[.`+�s�#c�!��J9v��DR����C�Z�[�cf��]�=�r�}xP�]��h��$�"̴��XF��4��S/��a/$#�=s�P���}�J�&rO��w�o�������K�d��bC�e�u!�����$��\O��?4d��K�NcS�6��s��� �!�םe� u�iy>�\���9�h�3�Yr �G��M�R?�䮎         �   x�e��
1D�ӏY�&��ы'�K�"��BY�����E�a&�Lvh��zDl[�h��US���
�em�#��D���<��3;F��v�R�����MK�aXa]��,�dFN�%�Ml���À�A?��]�irν��60         �   x�U�1
�0���}��	$i�:�Х����	QBbm)�x���]�@�{���?x�f�_9`'%2	7sE9N�	���z�'w	�8���7.%�|�i���(94�ǀ���r�`�~�8����߃B���Z����P��7nceӠ�"�/26     