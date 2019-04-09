package org.demoreport.reportdynamic.repository;

import org.demoreport.reportdynamic.model.ReportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomSqlQuery {
    @Autowired
    private EntityManager entityManager;


    public List<ReportData> reportDataList(){
       Query query= entityManager.createNativeQuery("SELECT\n" +
                "\touterquery.ampid,\n" +
                        "\touterquery.project_title AS project_title,\n" +
                        "\touterquery.creator,\n" +
                        "\n" +
                        "\touterquery.modified_date,\n" +
                        "\touterquery.locationname,\n" +
                        "\touterquery.actual_start_date,\n" +
                        "\touterquery.sectorname AS primary_sector,\n" +
                        "\touterquery.budget_code,\n" +
                        "\touterquery.commitment AS commitment,\n" +
                        "\touterquery.disbursement AS disbursement \n" +
                        "FROM\n" +
                        "\t(\n" +
                        "\tSELECT\n" +
                        "\t\t\"row_number\" () OVER ( PARTITION BY exe.ampid, donor ORDER BY exe.activity_id DESC ) AS prp,* \n" +
                        "\tFROM\n" +
                        "\t\t(\n" +
                        "\t\tSELECT\n" +
                        "\t\t\tstd.donor,\n" +
                        "\t\t\tstd.projecttitle AS project_title,\n" +
                        "\t\t\tSUM ( std.commitment ) AS commitment,\n" +
                        "\t\t\tSUM ( std.disbursement ) AS disbursement,\n" +
                        "\t\t\tstd.activityid AS activity_id,\n" +
                        "\t\t\tstd.org_id AS org_id,\n" +
                        "\t\t\tstd.startdate AS starteddate,\n" +
                        "\t\t\tstd.completiondate AS completiondate,\n" +
                        "\t\t\tstd.project_status AS project_status,\n" +
                        "\t\t\tstd.catvalue AS budget_type,\n" +
                        "\t\t\tstd.sectorname AS sectorname,\n" +
                        "\t\t\tstd.ampid AS ampid,\n" +
                        "\t\t\tstd.locationname AS locationname,\n" +
                        "\t\t\tstd.donor_group AS donor_group,\n" +
                        "\t\t\tstd.donor_group_id AS donor_group_id,\n" +
                        "\t\t\tstd.first_names AS creator,\n" +
                        "\t\t\n" +
                        "\t\t\tstd.modified_date,\n" +
                        "\t\t\tstd.actual_start_date,\n" +
                        "\t\t\tstd.budget_code \n" +
                        "\t\tFROM\n" +
                        "\t\t\t(\n" +
                        "\t\t\tSELECT ROW_NUMBER\n" +
                        "\t\t\t\t() OVER ( PARTITION BY st.fundingid, commitment, disbursement, donor ORDER BY st.activityid DESC ) sn,* \n" +
                        "\t\t\tFROM\n" +
                        "\t\t\t\t(\n" +
                        "\t\t\t\tSELECT\n" +
                        "\t\t\t\t\taav.amp_activity_id AS activityid,\n" +
                        "\t\t\t\t\tfundtran.fundid AS fundingid,\n" +
                        "\t\t\t\t\taav.NAME AS projecttitle,\n" +
                        "\t\t\t\t\tao.\"name\" AS donor,\n" +
                        "\t\t\t\t\tfundtran.commitment AS commitment,\n" +
                        "\t\t\t\t\tfundtran.disbursement AS disbursement,\n" +
                        "\t\t\t\t\tao.amp_org_id AS org_id,\n" +
                        "\t\t\t\t\taav.proposed_approval_date AS startdate,\n" +
                        "\t\t\t\t\taav.contracting_date AS completiondate,\n" +
                        "\t\t\t\t\taacva.amp_categoryvalue_id AS project_status,\n" +
                        "\t\t\t\t\tacv.category_value AS catvalue,\n" +
                        "\t\t\t\t\tsec.NAME AS sectorname,\n" +
                        "\t\t\t\t\taav.amp_id AS ampid,\n" +
                        "\t\t\t\t\tacvl.location_name AS locationname,\n" +
                        "\t\t\t\t\taog.org_grp_name AS donor_group,\n" +
                        "\t\t\t\t\taog.amp_org_grp_id AS donor_group_id,\n" +
                        "\t\t\t\t\tdu.first_names,\n" +
                        "\t\t\t\t\tdu.last_name,\n" +
                        "\t\t\t\t\taav.modified_date,\n" +
                        "\t\t\t\t\taav.actual_start_date,\n" +
                        "\t\t\t\t\taorb.budget_code \n" +
                        "\t\t\t\tFROM\n" +
                        "\t\t\t\t\t(\n" +
                        "\t\t\t\t\tSELECT\n" +
                        "\t\t\t\t\t\tbefconv.fundid AS fundid,\n" +
                        "\t\t\t\t\t\tSUM ( befconv.commitment ) AS commitment,\n" +
                        "\t\t\t\t\t\tSUM ( befconv.disbursement ) AS disbursement \n" +
                        "\t\t\t\t\tFROM\n" +
                        "\t\t\t\t\t\t(\n" +
                        "\t\t\t\t\t\tSELECT\n" +
                        "\t\t\t\t\t\t\tcomdis.fundid,\n" +
                        "\t\t\t\t\t\t\tSUM ( commitment ) / getexchange ( comdis.currcode, comdis.transcdate ) AS commitment,\n" +
                        "\t\t\t\t\t\t\tSUM ( disbursement ) / getexchange ( comdis.currcode, comdis.transcdate ) AS disbursement \n" +
                        "\t\t\t\t\t\tFROM\n" +
                        "\t\t\t\t\t\t\t(\n" +
                        "\t\t\t\t\t\t\tSELECT A\n" +
                        "\t\t\t\t\t\t\t\t.transaction_amount AS totalamount,\n" +
                        "\t\t\t\t\t\t\t\tA.transaction_date AS transcdate,\n" +
                        "\t\t\t\t\t\t\t\tb.currency_code AS currcode,\n" +
                        "\t\t\t\t\t\t\t\tA.amp_funding_id AS fundid,\n" +
                        "\t\t\t\t\t\t\tCASE\n" +
                        "\t\t\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t\t\t\tWHEN A.transaction_type = 0 THEN\n" +
                        "\t\t\t\t\t\t\t\t\tA.transaction_amount ELSE 0 \n" +
                        "\t\t\t\t\t\t\t\tEND commitment,\n" +
                        "CASE\n" +
                        "\t\n" +
                        "\tWHEN A.transaction_type = 1 THEN\n" +
                        "\tA.transaction_amount ELSE 0 \n" +
                        "\tEND disbursement \n" +
                        "FROM\n" +
                        "\tamp_funding_detail\n" +
                        "\tA INNER JOIN amp_currency b ON A.amp_currency_id = b.amp_currency_id \n" +
                        "WHERE\n" +
                        "\tA.adjustment_type = 264 \n" +
                        "\tAND A.transaction_date BETWEEN '2014-07-16' \n" +
                        "\tAND '2018-07-15' \n" +
                        "\tAND A.transaction_type IN ( 0, 1 ) --AND A.amp_funding_id in (select amp_funding_id from amp_funding where amp_activity_id in (select amp_activity_id from amp_activity_version where amp_activity_id = 8799))\n" +
                        "\t\n" +
                        "\t) comdis \n" +
                        "GROUP BY\n" +
                        "\tcomdis.fundid,\n" +
                        "\tcomdis.currcode,\n" +
                        "\tcomdis.transcdate \n" +
                        "\t) befconv \n" +
                        "GROUP BY\n" +
                        "\tbefconv.fundid --befconv.fundid in (46997,46998,46999,47000)\n" +
                        "\t\n" +
                        "\t) fundtran\n" +
                        "\tINNER JOIN amp_funding af ON fundtran.fundid = af.amp_funding_id\n" +
                        "\tINNER JOIN amp_activity_version aav ON af.amp_activity_id = aav.amp_activity_id\n" +
                        "\tINNER JOIN amp_activities_categoryvalues aacv ON aacv.amp_activity_id = af.amp_activity_id\n" +
                        "\tINNER JOIN amp_activities_categoryvalues aacva ON aacva.amp_activity_id = aacv.amp_activity_id\n" +
                        "\tINNER JOIN amp_category_value acv ON aacv.amp_categoryvalue_id = acv.\n" +
                        "\tID INNER JOIN amp_org_role aor ON aor.activity = af.amp_activity_id\n" +
                        "\tINNER JOIN amp_org_role_budget aorb ON aor.amp_org_role_id = aorb.amp_org_role_id \n" +
                        "\tINNER JOIN amp_organisation ao ON af.amp_donor_org_id = ao.amp_org_id\n" +
                        "\tINNER JOIN amp_org_group aog ON aog.amp_org_grp_id = ao.org_grp_id\n" +
                        "\tINNER JOIN amp_activity_location aal ON aal.amp_activity_id = af.amp_activity_id\n" +
                        "\tINNER JOIN amp_location al ON al.amp_location_id = aal.amp_location_id\n" +
                        "\tINNER JOIN amp_category_value_location acvl ON acvl.ID = al.location_id\n" +
                        "\tINNER JOIN amp_activity_sector aas ON aas.amp_activity_id = af.amp_activity_id\n" +
                        "\tINNER JOIN amp_sector sec ON aas.amp_sector_id = sec.amp_sector_id\n" +
                        "\tINNER JOIN dg_user du ON du.ID = aav.activity_creator \n" +
                        "WHERE\n" +
                        "\tsec.sector_code = '101' \n" +
                        "\tAND aav.draft = 'f' \n" +
                        "\tAND aav.amp_activity_id IN ( SELECT aps.activityid FROM ( SELECT NAME, MAX ( amp_activity_id ) AS activityid FROM amp_activity_version GROUP BY NAME ) aps ) \n" +
                        "\tAND -- fundtran.trandate BETWEEN '0001-01-01' and '2018-07-15'\n" +
                        "\taacv.amp_categoryvalue_id IN ( 252, 253 ) --onbudget:253, offbudget:252\n" +
                        "\t\n" +
                        "\tAND aacva.amp_categoryvalue_id IN ( 132, 185, 126 ) -- on-going, 126:new, 185: completed\n" +
                        "\t\n" +
                        "\tAND aav.approval_status LIKE'%approved%' \n" +
                        "\t) st \n" +
                        "\t) std \n" +
                        "WHERE\n" +
                        "\tstd.sn = 1 \n" +
                        "GROUP BY\n" +
                        "\tstd.activityid,\n" +
                        "\tstd.ampid,\n" +
                        "\tstd.donor_group,\n" +
                        "\tdonor_group_id,\n" +
                        "\tstd.donor,\n" +
                        "\torg_id,\n" +
                        "\tbudget_type,\n" +
                        "\tstd.projecttitle,\n" +
                        "\tproject_status,\n" +
                        "\tstarteddate,\n" +
                        "\tcompletiondate,\n" +
                        "\tsectorname,\n" +
                        "\tlocationname,\n" +
                        "\tstd.first_names,\n" +
                        "\tstd.modified_date,\n" +
                        "\tstd.actual_start_date,\n" +
                        "\tstd.budget_code \n" +
                        "ORDER BY\n" +
                        "\tstd.activityid DESC \n" +
                        "\t) exe \n" +
                        "\t) outerquery \n" +
                        "WHERE\n" +
                        "\touterquery.prp = 1 \n" +
                        "\tAND NOT ( outerquery.commitment = 0 AND outerquery.disbursement = 0)",ReportData.class);

       List<ReportData>  reportDataList=query.getResultList();

       return reportDataList;
    }
}
