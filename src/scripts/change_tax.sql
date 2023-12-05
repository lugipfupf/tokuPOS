do
$$
    declare
        new_taxname  taxcategories.name%type = 'MwSt 8.1';
        new_taxrate  taxes.rate%type         = 0.081;
        new_taxcatid taxcategories.id%type;
    begin
        -- create new tax category
        insert into taxcategories
            (id, name)
        values (gen_random_uuid(), new_taxname)
        returning id into new_taxcatid;

        -- create new tax rate
        insert into taxes
        (id, name, category, custcategory, parentid, rate, ratecascade, rateorder)
        values (gen_random_uuid(), new_taxname, new_taxcatid, null, null, new_taxrate, false, null);

        -- calc all prices into tmp table -- readability
        create temp table tmp_products as
        select p.id
             , p.pricesell + (p.pricesell * t.rate)                       as curr_price_incl
             , (p.pricesell + (p.pricesell * t.rate)) / (1 + new_taxrate) * new_taxrate as new_tax
        from products p
                 join taxcategories tc on tc.id = p.taxcat
                 join taxes t on tc.id = t.category;

        update products p
        set
            pricesell = (select tp.curr_price_incl - tp.new_tax from tmp_products tp where id = p.id),
            taxcat    = new_taxcatid
        where 1 = 1;
    end;
$$
