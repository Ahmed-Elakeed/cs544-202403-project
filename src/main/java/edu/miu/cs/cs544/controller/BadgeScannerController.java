package edu.miu.cs.cs544.controller;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.BadgeScanner;
import edu.miu.cs.cs544.service.BadgeScannerService;
import edu.miu.cs.cs544.service.contract.BadgeScannerPayload;
import edu.miu.cs.cs544.service.mapper.BadgeScannerPayloadToBadgeScannerMapper;
import edu.miu.cs.cs544.service.mapper.BadgeScannerToBadgeScannerPayloadMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/badgescanners")
public class BadgeScannerController
        extends BaseReadWriteController<BadgeScannerPayload, BadgeScanner, Long> {

    private final BadgeScannerService badgeScannerService;
    private final BadgeScannerPayloadToBadgeScannerMapper payloadToEntityMapper;
    private final BadgeScannerToBadgeScannerPayloadMapper entityToPayloadMapper;
    @Autowired
    public BadgeScannerController(BadgeScannerService badgeScannerService,
                                  BadgeScannerPayloadToBadgeScannerMapper payloadToEntityMapper,
                                  BadgeScannerToBadgeScannerPayloadMapper entityToPayloadMapper) {
        this.badgeScannerService = badgeScannerService;
        this.payloadToEntityMapper = payloadToEntityMapper;
        this.entityToPayloadMapper = entityToPayloadMapper;
    }

//    @PostMapping
//    public ResponseEntity<BadgeScannerPayload> createBadgeScanner(@RequestBody BadgeScannerPayload payload) {
//        // Convert the payload to BadgeScanner entity
//        BadgeScanner badgeScanner = payloadToEntityMapper.map(payload);
//
//        // Save the BadgeScanner entity using the service
//        BadgeScanner savedBadgeScanner = badgeScannerService.create(badgeScanner);
//
//        // Convert the saved entity back to BadgeScannerPayload and return in the response
//        BadgeScannerPayload savedPayload = entityToPayloadMapper.map(savedBadgeScanner);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedPayload);
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBadgeScanner(@PathVariable Long id) {
//        // Call the service method to delete the badge scanner by id
//        badgeScannerService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<BadgeScannerPayload> updateBadgeScanner(@PathVariable Long id, @RequestBody BadgeScannerPayload payload) {
//        // Call the service method to update the badge scanner with the given id
//        BadgeScannerPayload updatedBadgeScanner = badgeScannerService.update(id, payload);
//        return ResponseEntity.ok(updatedBadgeScanner);
//    }
//    @PatchMapping("/{id}")
//    public ResponseEntity<BadgeScannerPayload> patchBadgeScanner(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
//        // Call the service method to patch (partially update) the badge scanner with the given id
//        BadgeScannerPayload patchedBadgeScanner = badgeScannerService.patch(id, updates);
//        return ResponseEntity.ok(patchedBadgeScanner);
//    }
}
