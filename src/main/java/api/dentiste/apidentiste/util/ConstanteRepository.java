package api.dentiste.apidentiste.util;

public class ConstanteRepository {
	public static final String searchUser = "SELECT * FROM user u WHERE u.nom =:nom";
	public static final String searchConsultationByDate = "SELECT * FROM consultation c WHERE c.date =:date";
	public static final String searchConsultationByUser = "SELECT c.id,c.date,c.heure,c.observations,c.user_id FROM consultation c inner join user as u on u.id = c.user_id WHERE u.nom =:nom";
	public static final String searchRole = "SELECT * FROM role  r WHERE name =:nom";
	public static final String searchAppointmentByUser = "SELECT c.id,c.date,c.heure,c.user_id FROM appointment c inner join user as u on u.id = c.user_id WHERE u.nom =:name";
	public static final String searchAppointmentByDate = "SELECT * FROM appointment c WHERE c.date =:date";
}
