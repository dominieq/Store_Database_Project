CREATE OR REPLACE FUNCTION dostepnosc(cf_id IN NUMBER)
	RETURN NUMBER
	IS cf_il NUMBER (10,0);
	BEGIN
		SELECT SUM(ilość)
		INTO cf_il
		FROM stan_magazynowy
		WHERE idtowaru = c_id;
		RETURN(cf_il);
	END;
/



CREATE OR REPLACE PROCEDURE przesun
	(cf_id IN NUMBER, cf_from IN NUMBER, cf_to IN NUMBER, cf_ile IN NUMBER)
	AS
	BEGIN
		UPDATE stan_magazynowy
		SET ilosc = ilosc - cf_ile
		WHERE idtowaru = cf_id AND idmagazuny = cf_from;
		
		UPDATE stan_magazynowy
		SET ilosc = ilosc + cf_ile
		WHERE idtowaru = cf_id AND idmagazuny = cf_to;
	END;
/