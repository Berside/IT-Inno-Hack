import React from 'react';

interface TaskProps {
  task: {
    id: number;
    text: string;
    completed: boolean;
    date: Date;
  };
  onDelete: () => void;
}

const Task: React.FC<TaskProps> = ({ task, onDelete }) => {
  return (
    <div className="task">
      <input
        type="checkbox"
        checked={task.completed}
        onChange={() => onDelete()}
      />
      <span>{task.text}</span>
    </div>
  );
};

export default Task;