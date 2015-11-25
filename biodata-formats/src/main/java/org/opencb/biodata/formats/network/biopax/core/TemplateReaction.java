/*
 * Copyright 2015 OpenCB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opencb.biodata.formats.network.biopax.core;

import java.util.List;

public class TemplateReaction extends Interaction {

    private List<String> product;
    private List<String> regulatoryElement;
    private List<String> template;

    public TemplateReaction(List<String> availability, List<String> comment,
                            List<String> dataSource, List<String> evidence, List<String> name,
                            List<String> xref, List<String> interactionType,
                            List<String> participant, List<String> product,
                            List<String> regulatoryElement, List<String> template) {
        super(availability, comment, dataSource, evidence, name, xref,
                interactionType, participant);
        this.product = product;
        this.regulatoryElement = regulatoryElement;
        this.template = template;
    }

    public List<String> getProduct() {
        return product;
    }

    public void setProduct(List<String> product) {
        this.product = product;
    }

    public List<String> getRegulatoryElement() {
        return regulatoryElement;
    }

    public void setRegulatoryElement(List<String> regulatoryElement) {
        this.regulatoryElement = regulatoryElement;
    }

    public List<String> getTemplate() {
        return template;
    }

    public void setTemplate(List<String> template) {
        this.template = template;
    }

}
