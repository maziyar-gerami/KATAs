# Day 4 / 200: Resilient Log Processor

### Difficulty: Medium
**Estimated Solve Time:** 45 minutes

---

### Concepts Practiced
- `java.nio.file.Files` and `java.nio.file.Path`
- Handling `Checked Exceptions` (IOException)
- Using `try-with-resources`
- Functional Exception Handling (Streams + Exceptions)
- Resource Cleanup

---

### Problem Description
You are tasked with reading a large log file where each line follows the format:
`[TIMESTAMP] [LEVEL] [MESSAGE]`
Example: `2024-05-21 INFO User logged in`

Your goal is to parse this file, filter out "ERROR" logs, and return them as a list of strings.

### Requirements
1. **Method signature:** `public List<String> getErrorLogs(Path path)`
2. **Robustness:** If the file does not exist or cannot be read, the method should handle the `IOException` and return an empty `List` (log the error to `System.err`).
3. **Efficiency:** Use `Files.lines(path)` to process the file lazily. This is crucial for large logs.
4. **Cleanup:** Ensure the file stream is closed automatically.

### Constraints
- The `path` parameter might point to a directory instead of a file (your code should handle this gracefully).
- Do not read the entire file into memory at once.
- Use `try-with-resources`.

### Example Input File (`logs.txt`)
```text
2024-05-21 INFO Server started
2024-05-21 ERROR Database connection failed
2024-05-21 WARN High memory usage
2024-05-21 ERROR NullPointerException in module X
