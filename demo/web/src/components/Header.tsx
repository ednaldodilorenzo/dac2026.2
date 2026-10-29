
type HeaderProps = {
    title: string;
    click?: () => void;
}

export default function Header({ title, click }: HeaderProps) {
  return (
    <header onClick={click} className="white-back">
      {title}
    </header>
  );
}