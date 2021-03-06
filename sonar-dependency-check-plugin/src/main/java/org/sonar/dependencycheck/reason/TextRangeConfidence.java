/*
 * Dependency-Check Plugin for SonarQube
 * Copyright (C) 2015-2017 Steve Springett
 * steve.springett@owasp.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.dependencycheck.reason;

import java.util.Objects;

import org.sonar.api.batch.fs.TextRange;
import org.sonar.dependencycheck.parser.element.Confidence;

public class TextRangeConfidence implements Comparable<TextRangeConfidence>{
    private final TextRange textrange;
    private final Confidence confidence;
    /**
     * @param textrange
     * @param confidence
     */
    public TextRangeConfidence(TextRange textrange, Confidence confidence) {
        this.textrange = textrange;
        this.confidence = confidence;
    }
    /**
     * @return the textrange
     */
    public TextRange getTextrange() {
        return textrange;
    }
    /**
     * @return the confidence
     */
    public Confidence getConfidence() {
        return confidence;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(confidence, textrange);
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TextRangeConfidence)) {
            return false;
        }
        TextRangeConfidence other = (TextRangeConfidence) obj;
        return confidence == other.confidence && Objects.equals(textrange, other.textrange);
    }
    @Override
    public int compareTo(TextRangeConfidence other) {
        if (this.equals(other)) {
            return 0;
        }
        return confidence.compareTo(other.getConfidence());
    }
}
