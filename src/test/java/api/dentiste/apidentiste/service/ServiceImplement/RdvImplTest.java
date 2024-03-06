package api.dentiste.apidentiste.service.ServiceImplement;

import api.dentiste.apidentiste.dto.RdvDto;
import api.dentiste.apidentiste.entity.Rdv;
import api.dentiste.apidentiste.mapper.AppointmentsMapper;
import api.dentiste.apidentiste.repository.AppointmentRepository;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RdvImplTest {
    @InjectMocks
   private RdvImpl appointment;


 @Test
    void addAppointment() {
     AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);

     // Création d'un mock pour l'objet AppointmentMapper
     AppointmentsMapper appointmentMapper = mock(AppointmentsMapper.class);
     RdvDto rdvDto = new RdvDto();
     rdvDto.setId(1L);

     Rdv rdvEntity = new Rdv();
     rdvEntity.setId(1L);

     // Simuler le comportement du mapper pour retourner l'entité fictive
     when(appointmentMapper.transformaDtoToEntity(any(RdvDto.class))).thenReturn(rdvEntity);

     // Création d'un objet AppointmentService en lui passant les mocks en paramètres
     RdvImpl appointmentService = new RdvImpl(appointmentMapper,appointmentRepository);

     // Appel de la méthode addAppointment avec l'objet fictif
     appointmentService.addAppointment(rdvDto);

     // Utilisation de Mockito pour capturer l'argument passé à la méthode save du mock AppointmentRepository
     ArgumentCaptor<Rdv> captor = ArgumentCaptor.forClass(Rdv.class);
     verify(appointmentRepository).save(captor.capture());

     // Vérification que l'argument capturé correspond bien à l'objet transformé par le mapper
     Rdv capturedEntity = captor.getValue();

     assertEquals(rdvDto.getId(), capturedEntity.getId());
     assertEquals(rdvDto.getDate(), capturedEntity.getDate());

    }



    @Test
    void updateAppointment() {
     AppointmentRepository  appointmentRepository = mock(AppointmentRepository.class);
     AppointmentsMapper appointmentsMapper = mock(AppointmentsMapper.class);

     RdvDto rdvDto = new RdvDto();
     rdvDto.setId(1L);

     Rdv rdvEntity = new Rdv();
     rdvEntity.setId(1L);
     // Création d'un objet AppointmentService en lui passant les mocks en paramètres
     RdvImpl appointmentService = new RdvImpl(appointmentsMapper,appointmentRepository);

     // Simuler le comportement du mapper pour retourner l'entité fictive
     when(appointmentsMapper.transformaDtoToEntity(any(RdvDto.class))).thenReturn(rdvEntity);
     when(appointmentRepository.existsById(rdvEntity.getId())).thenReturn(true);
     appointmentService.updateAppointment(rdvDto);

     ArgumentCaptor<Rdv> captor = ArgumentCaptor.forClass(Rdv.class);
     verify(appointmentRepository).existsById(rdvEntity.getId());
     verify(appointmentRepository).save(captor.capture());

     // Vérification que l'argument capturé correspond bien à l'objet transformé par le mapper
     Rdv capturedEntity = captor.getValue();

     assertEquals(rdvDto.getId(), capturedEntity.getId());
     assertEquals(rdvDto.getDate(), capturedEntity.getDate());

    }

    @Test
    void getListAppointment() {
     AppointmentRepository  appointmentRepository = mock(AppointmentRepository.class);
     AppointmentsMapper appointmentsMapper = mock(AppointmentsMapper.class);

     List<RdvDto> rdvDtoList = new ArrayList<>();
     RdvDto rdvDto = new RdvDto();
     rdvDto.setId(1L);
     rdvDtoList.add(rdvDto);
     Rdv rdvEntity = new Rdv();
     rdvEntity.setId(1L);
     List<Rdv> rdvList = new ArrayList<>();
     rdvList.add(rdvEntity);
     // Création d'un objet AppointmentService en lui passant les mocks en paramètres
     RdvImpl appointmentService = new RdvImpl(appointmentsMapper,appointmentRepository);
    //le mock des differente methode
     when(appointmentRepository.findAll()).thenReturn(rdvList);
     when(appointmentsMapper.listtoRendezVousDto(rdvList)).thenReturn(rdvDtoList);

     List<RdvDto> result = appointmentService.getListAppointment();

     verify(appointmentRepository).findAll();
     verify(appointmentsMapper).listtoRendezVousDto(rdvList);

     assertEquals(rdvDtoList, result);
    }

    @Test
    void deleteAppointment() {
     AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
     AppointmentsMapper appointmentsMapper = mock(AppointmentsMapper.class);
     Rdv rdv = new Rdv();
     RdvDto rdvDto =new RdvDto();

     RdvImpl appointmentService = new RdvImpl(appointmentsMapper,appointmentRepository);
     when(appointmentRepository.existsById(any(Long.class))).thenReturn(true);

     appointmentService.deleteAppointment(any(Long.class));
     verify(appointmentRepository).existsById(any(Long.class));
    }

    @Test
    void searchAppointmentByDate() {
     AppointmentRepository appointmentRepository = mock(AppointmentRepository.class);
     AppointmentsMapper appointmentsMapper = mock(AppointmentsMapper.class);
     Rdv rdv = new Rdv();
     rdv.setId(1L);
     RdvDto rdvDto =new RdvDto();

     RdvImpl appointmentService = new RdvImpl(appointmentsMapper,appointmentRepository);
     //le mock des differente methode
     List<Rdv> rdvList = new ArrayList<>();
     List<RdvDto> rdvDtoList = new ArrayList<>();
     rdvList.add(rdv);

     rdvDto.setId(1L);
     rdvDtoList.add(rdvDto);

     when(appointmentRepository.searchAppointmentByDate(new Date())).thenReturn(rdvList);
     when(appointmentsMapper.listtoRendezVousDto(rdvList)).thenReturn(rdvDtoList);
     List<RdvDto> result = appointmentService.searchAppointmentByDate(new Date());
//     verify(appointmentRepository).searchAppointmentByDate(new Date());
//     verify(appointmentsMapper).listtoRendezVousDto(appointmentList);
     ArgumentCaptor<Rdv> captor = ArgumentCaptor.forClass(Rdv.class);

    }

    @Test
    void searchAppointmentByUser() {
    }

    @Test
    void testAddAppointment() {
    }

    @Test
    void testUpdateAppointment() {
    }

    @Test
    void testGetListAppointment() {
    }

    @Test
    void testDeleteAppointment() {
    }

    @Test
    void testSearchAppointmentByDate() {
    }

    @Test
    void testSearchAppointmentByUser() {
    }
}