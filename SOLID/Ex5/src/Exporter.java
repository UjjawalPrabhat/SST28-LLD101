/**
 * Exports the request to the specified format.
 * 
 * Preconditions: 
 *   - req.body must not be null or empty
 * 
 * Postconditions:
 *   - Returns ExportResult with non-null bytes
 *   - If preconditions violated, [throws IllegalArgumentException]
 */

public interface Exporter {
    public ExportResult export(ExportRequest req);
}
