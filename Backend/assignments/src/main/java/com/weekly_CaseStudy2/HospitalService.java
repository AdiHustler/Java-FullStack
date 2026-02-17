package com.weekly_CaseStudy2;


import java.util.List;

public class HospitalService {

    private PatientDAO patientDAO = new PatientDAO();
    private DoctorDAO doctorDAO = new DoctorDAO();
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void registerPatient(Patient p) {
        patientDAO.savePatient(p);
    }

    public void addAppointmentsToDoctor(long doctorId,
                                        List<Appointment> list) {

        Doctor d = doctorDAO.findDoctor(doctorId);
        d.getAppointments().addAll(list);
        doctorDAO.updateDoctor(d);
    }

    public void assignAppointmentToPatient(long appId,
                                           Patient p) {

        Appointment a = appointmentDAO.findAppointment(appId);
        a.setPatient(p);
        appointmentDAO.updateAppointment(a);
    }

    public void updateFee(long id, double fee) {
        Appointment a = appointmentDAO.findAppointment(id);
        a.setFee(fee);
        appointmentDAO.updateAppointment(a);
    }
}
