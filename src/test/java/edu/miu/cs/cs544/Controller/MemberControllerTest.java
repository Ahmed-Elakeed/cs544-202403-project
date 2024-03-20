package edu.miu.cs.cs544.Controller;

import edu.miu.cs.cs544.controller.MemberController;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MemberController.class)
@AutoConfigureMockMvc(addFilters = false)
class MemberControllerTest {

    @MockBean
    private MemberService memberService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRolesForMember() throws Exception {
        Long memberId = 1L;
        List<Role> roles = Arrays.asList(new Role(1L, "Role1", null)
                , new Role(2L, "Role2", null));


        Mockito.when(memberService.getAllRoleForMember(memberId)).thenReturn(roles);

        mockMvc.perform(get("/members/{memberId}/roles", memberId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(roles.size()));
    }

    @Test
    public void testCreateRole() throws Exception {
        Long memberId = 1L;
        Role role = new Role(null, "Role1", null);
        Role createdRole = new Role(1L, "Role1", null);

        Mockito.when(memberService.createRole(Mockito.eq(memberId), Mockito.any(Role.class))).thenReturn(createdRole);

        mockMvc.perform(post("/members/{memberId}/roles", memberId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"role\":\"Role1\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }

    @Test
    public void testUpdateRole() throws Exception {
        Long memberId = 1L;
        Role updatedRole = new Role(1L, "UpdatedRole1", null);

        // Mocking the behavior of memberService.updateRole method
        Mockito.when(memberService.updateRole(Mockito.eq(memberId), Mockito.any(Role.class))).thenReturn(updatedRole);

        // Performing the PUT request to update the role
        mockMvc.perform(put("/members/{memberId}/roles", memberId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"role\":\"UpdatedRole1\"}"))
                // Verifying the response status is OK
                .andExpect(status().isOk())
                // Verifying the returned JSON has the correct role value
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("UpdatedRole1"));
    }

    @Test
    public void testDeleteRole() throws Exception {
        Long memberId = 1L;
        Long roleId = 1L;
        Mockito.when(memberService.deleteRoleForMember(memberId, roleId)).thenReturn("Deleted");

        mockMvc.perform(delete("/members/{memberId}/roles/{roleId}", memberId, roleId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Deleted"));
    }
    @Test
    public void testGetRoleForMember() throws Exception {
        Long memberId = 1L;
        Long roleId = 1L;
        Role role = new Role(roleId, "Role1", null);

        Mockito.when(memberService.getRoleForMember(memberId, roleId)).thenReturn(role);

        mockMvc.perform(get("/members/{memberId}/roles/{roleId}", memberId, roleId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("Role1"));
    }







//    @Test
//    void getAllSessionsForEventTest() {
//        long memberId = 1L;
//
//
//        when(memberService.getAttendence(memberId)).thenReturn((AttendanceResponseDTO) Collections.emptyList());
//
//
//        ResponseEntity<?> responseEntity = memberController.getAllSessionsForEvent(memberId);
//
//
//        assertEquals(200, responseEntity.getStatusCodeValue());
//        verify(memberService, times(1)).getAttendence(memberId);
//    }
//}






}



