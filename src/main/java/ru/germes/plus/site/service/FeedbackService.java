package ru.germes.plus.site.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.germes.plus.site.model.feedbacks.FeedbackOnProductForIndividual;
import ru.germes.plus.site.model.persons.IndividualPerson;
import ru.germes.plus.site.model.products.ProductForIndividual;
import ru.germes.plus.site.repository.FeedbackRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeedbackService {

    private static final Log log = LogFactory.getLog(FeedbackService.class);
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private ProductForIndividualService productForIndividualService;

    public FeedbackOnProductForIndividual sendFeedback(Long productId, IndividualPerson individualPerson, String text) {

        log.info(productId);

        ProductForIndividual productForIndividual = productForIndividualService.getById(productId);

        FeedbackOnProductForIndividual feedbackOnProductForIndividual = new FeedbackOnProductForIndividual();
        feedbackOnProductForIndividual.setIndividualPerson(individualPerson);
        feedbackOnProductForIndividual.setProductForIndividual(productForIndividual);
        feedbackOnProductForIndividual.setText(text);
        feedbackOnProductForIndividual.setGrade(5);
        feedbackOnProductForIndividual.setDate(LocalDate.now());

        return feedbackRepository.save(feedbackOnProductForIndividual);
    }

    public List<FeedbackOnProductForIndividual> getByProductForIndividual(Long productId) {
        ProductForIndividual product = productForIndividualService.getById(productId);
        return feedbackRepository.findByProductForIndividual(product);
    }
}
