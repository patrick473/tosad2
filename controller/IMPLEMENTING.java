package controller;

import dao.*;
import domain.*;

public class IMPLEMENTING {

    generateDAO gdao = new generateDAO();
    implementBusinessRuleDAO imdao = new implementBusinessRuleDAO();
    ACMPDAO adao = new ACMPDAO();
    ARNGDAO rdao = new ARNGDAO();
    ATLRDAO ldao = new ATLRDAO();
    IECRDAO idao = new IECRDAO();
    OTHRDAO odao = new OTHRDAO();
    TCMPDAO tdao = new TCMPDAO();

    public void create(int id,String type){
        update(id,type);
        imdao.updateActiveBusinessRule(id);
    }

    public void update(int id,String type){
        switch(type.toUpperCase()){

            case "ATTRIBUTECOMPARERULE":
                attributeCompareRule ac = adao.getByID(id);
                generateAttributeCompareRule gac = new generateAttributeCompareRule();
                ac = gac.decideTypeGeneratedAttrComp(ac);
                gdao.implementbr(ac.getGeneratedCode());
                imdao.updateGeneratedCode(ac.getGeneratedCode(),id);

                break;
            case "ATTRIBUTELISTRULE":
                attributeListRule al = ldao.getByID(id);
                generateAttributeListrule gal = new generateAttributeListrule();
                al = gal.decideTypeGeneratedAttrList(al);
                gdao.implementbr(al.getGeneratedCode());
                imdao.updateGeneratedCode(al.getGeneratedCode(),id);
                break;
            case "ATTRIBUTERANGERULE":
                attributeRangeRule ar = rdao.getByID(id);
                generateAttributeRangeRule gar = new generateAttributeRangeRule();
                ar = gar.decideTypeGeneratedAttrRang(ar);
                gdao.implementbr(ar.getGeneratedCode());
                imdao.updateGeneratedCode(ar.getGeneratedCode(),id);
                break;
            case "IECOMPARERULE":
                interEntityCompareRule iec = idao.getByID(id);
                generateinterentityrule gic = new generateinterentityrule();
                iec = gic.decideTypeGeneratedIEcomp(iec);
                gdao.implementbr(iec.getGeneratedCode());
                imdao.updateGeneratedCode(iec.getGeneratedCode(),id);
                break;
            case "TUPLECOMPARERULE":
                tupleCompareRule tc = tdao.getByID(id);
                generateTupleCompareRule gtc = new generateTupleCompareRule();

                tc = gtc.decideTypeGeneratedTupleComp(tc);
                gdao.implementbr(tc.getGeneratedCode());
                imdao.updateGeneratedCode(tc.getGeneratedCode(),id);
                break;
            case "OTHERRULE":
                OtherRule or = odao.getByID(id);

                gdao.implementbr(or.getSql());
                imdao.updateGeneratedCode(or.getSql(),id);
                break;
        }
    }

    public void delete(int id,String type){

        switch(type.toUpperCase()){

            case "ATTRIBUTECOMPARERULE":
                attributeCompareRule ac = adao.getByID(id);
                gdao.deletebrfromtarget(ac.getName());
                break;
            case "ATTRIBUTELISTRULE":
                attributeListRule al = ldao.getByID(id);
                gdao.deletebrfromtarget(al.getName());
                break;
            case "ATTRIBUTERANGERULE":
                attributeRangeRule ar = rdao.getByID(id);
                gdao.deletebrfromtarget(ar.getName());
                break;
            case "IECOMPARERULE":
                interEntityCompareRule iec = idao.getByID(id);
                gdao.deletebrfromtarget(iec.getName());
                break;
            case "TUPLECOMPARERULE":
                tupleCompareRule tc = tdao.getByID(id);
                gdao.deletebrfromtarget(tc.getName());
                break;
            case "OTHERRULE":
                OtherRule or = odao.getByID(id);
                gdao.deletebrfromtarget(or.getName());
                break;
        }
        deleteDAO ddao = new deleteDAO();
        ddao.deleteBR(id);

    }

}
