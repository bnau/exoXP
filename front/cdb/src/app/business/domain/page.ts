export interface Page<T> {
    content: T[];
    first: boolean;
    last: boolean;
    number: number;
    totalPages: number;
}
